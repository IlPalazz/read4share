package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import track.individual.read4share.dto.Converter;
import track.individual.read4share.dto.request.PublishAdvRequest;
import track.individual.read4share.dto.response.AdvDetailsResponse;
import track.individual.read4share.exception.ItemNotFoundException;
import track.individual.read4share.model.*;
import track.individual.read4share.repository.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AdvServiceImpl implements AdvService {

    private final AdvRepo advRepo;
    private final Converter converter;
    private final UserRepo userRepo;
    private final CityRepo cityRepo;
    private final BookRepo bookRepo;
    private final CategoryService categoryService;
    private final ConditionRepo conditionRepo;

    @Override
    public AdvDetailsResponse getDetailsById(Long id) throws ItemNotFoundException {
        Optional<Adv> adv = this.advRepo.findById(id);
        if (adv.isEmpty())
            throw new ItemNotFoundException("Error: Adv with the given id does not exist!");
        return converter.toActiveAdvResponse(adv.get());
    }

    @Override
    public Adv getById(Long id) throws ItemNotFoundException {
        Optional<Adv> adv = this.advRepo.findById(id);
        if (adv.isEmpty())
            throw new ItemNotFoundException("Error: Adv with the given id does not exist!");
        return adv.get();    }

    @Override
    @Transactional
    public void publishAdv(PublishAdvRequest request) {
        Random random = new Random();

        Adv adv = Adv.builder()
                .descr(request.getAdvDescr())
                .price(request.getAdvPrice())
                .shipCost(request.getAdvShipCost())
                .publDate(LocalDateTime.now())
                .saleDate(null)
                .picPath("").build();

        // Set book
        Optional<Book> book = bookRepo.findBookByIsbn(request.getBookIsbn());
        if (book.isPresent())
            adv.setBook(book.get());
        else {
            // Get category
            Category category = null;
            Optional<Category> cat = categoryService.getByName(request.getBookCategory());

            if (cat.isEmpty()) {
                List<Category> categories = categoryService.getAll();
                category = categories.get(random.nextInt(categories.size()));
            }
            else category = cat.get();

            Book newBook = Book.builder()
                    .isbn(request.getBookIsbn())
                    .title(request.getBookTitle())
                    .author(request.getBookAuthor())
                    .publDate(request.getBookPublDate())
                    .publisher(request.getBookPublisher())
                    .language(request.getBookLanguage())
                    .coverUrl(request.getBookCoverUrl())
                    .avgRating(request.getBookAvgRating())
                    .category(category)
                    .build();
            bookRepo.save(newBook);

            adv.setBook(bookRepo.findBookByIsbn(request.getBookIsbn()).get());
        }

        // Get adv seller
        Optional<User> seller = userRepo.findById(request.getSellerId());
        if (seller.isEmpty())
            throw new ItemNotFoundException("User with id: " + request.getSellerId() + "not found!");
        adv.setSeller(seller.get());

        // Get book conditions
        if (request.getCondCode().equals("NW"))
            adv.setCondition(conditionRepo.findByCode(Conditions.NW).get());
        else {
            List<Condition> conditions = conditionRepo.findAll();
            for (Condition condition : conditions)
                if (condition.getCode().toString().equals(request.getCondCode()) &&
                        condition.isPen_underln() == request.isCondPen() &&
                        condition.isPenc_underln() == request.isCondPencil() &&
                        condition.isHighl_underln() == request.isCondHighl()) {
                    adv.setCondition(condition);
                    break;
                }
        }

        // Set city
        Optional<City> location = cityRepo.findById((long) random.nextInt(500));
        adv.setCity(location.get());

        // Save Adv
        advRepo.save(adv);

    }
}
