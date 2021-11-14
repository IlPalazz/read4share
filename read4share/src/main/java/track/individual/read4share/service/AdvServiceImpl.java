package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import track.individual.read4share.model.Book;
import track.individual.read4share.repository.BookRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvServiceImpl implements AdvService {

    private final BookRepo bookRepo;

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBook(String isbn) {
        return null;
    }
}
