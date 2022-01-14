package track.individual.read4share.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import track.individual.read4share.config.GlobalConstants;
import track.individual.read4share.dto.response.AdvOverviewResponse;
import track.individual.read4share.dto.response.SearchBookResponse;
import track.individual.read4share.exception.GBooksParseException;
import track.individual.read4share.exception.ItemNotFoundException;
import track.individual.read4share.repository.AdvRepo;
import track.individual.read4share.dto.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static track.individual.read4share.config.GlobalConstants.gBooksApiUrl;
import static track.individual.read4share.config.GlobalConstants.standardCover;

@Service
@RequiredArgsConstructor
public class AdvOverviewServiceImpl implements AdvOverviewService {

    private final AdvRepo advRepo;
    private final Converter converter;
    private final CategoryService catService;

    @Override
    public List<AdvOverviewResponse> getLatest(int size) {
        return converter.toAdvOverviewResponse(advRepo.findLatest(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewResponse> getBestRating(int size) {
        return converter.toAdvOverviewResponse(advRepo.findBestRating(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewResponse> getFree(int size) {
        return converter.toAdvOverviewResponse(advRepo.findFree(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewResponse> getFreeDel(int size) {
        return converter.toAdvOverviewResponse(advRepo.findFreeDel(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewResponse> getAsNew(int size) {
        return converter.toAdvOverviewResponse(advRepo.findAsNew(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewResponse> getByCategoryId(Long id, int page, int size) {
        // Check whether the category id is valid
        if (!catService.isValid(id))
            throw new ItemNotFoundException("Category with specified id not found");
        // Get the advertisements list
        return converter.toAdvOverviewResponse(advRepo.findByCatId(
                id, PageRequest.of(page, this.validateRecordsNumber(size))));
    }

    @Override
    public List<SearchBookResponse> getBookOverview(String title, String author) {
        List<SearchBookResponse> results = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        // Format GBooks search url
        String searchUrl = "";
        if (author.isEmpty() || author.isBlank())
            searchUrl = gBooksApiUrl + title;
        else
            searchUrl = gBooksApiUrl + title + "+inauthor:" + author;

        // Get the response
        ResponseEntity<String> response
                = restTemplate.getForEntity(searchUrl, String.class);

        //
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
        } catch (JsonProcessingException ex) {
            throw new GBooksParseException("Error: invalid GBooks response body");
        }

        ArrayNode items = (ArrayNode) root.get("items");
        for (JsonNode item : items) {

            JsonNode book = item.get("volumeInfo");

            SearchBookResponse bookResponse = SearchBookResponse.builder()
                    .title(book.get("title").asText())
                    .language(book.get("language").asText())
                    .build();

            // Get publication date
            try {
                String date = book.get("publishedDate").asText() + " 00:00";
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime publDate = LocalDateTime.parse(date, formatter);
                bookResponse.setPublDate(publDate);
            } catch (Exception e) {
                bookResponse.setPublDate(LocalDateTime.now().minusYears(4));
            }

            // Get author
            ArrayNode authors = (ArrayNode) book.get("authors");
            if (authors == null || authors.isNull())
                bookResponse.setAuthor("Unknown");
            else bookResponse.setAuthor(authors.get(0).asText());

            // Get category
            ArrayNode categories = (ArrayNode) book.get("categories");
            if (categories == null || categories.isNull() || categories.isEmpty())
                bookResponse.setCategory("");
            else bookResponse.setCategory(categories.get(0).asText());

            // Get ISBN
            ArrayNode identifiers = (ArrayNode) book.get("industryIdentifiers");
            if (identifiers == null || identifiers.isNull())
                break;


            for (JsonNode id : identifiers) {
                if (id.get("type").asText().equals("ISBN_13"))
                    bookResponse.setIsbn(id.get("identifier").asText());
            }

            // Get imgUrl
            JsonNode imageUrl = book.get("imageLinks");
            if (imageUrl == null || imageUrl.isNull())
                // No cover img for this book
                bookResponse.setCoverUrl(standardCover);
            else bookResponse.setCoverUrl(imageUrl.get("thumbnail").asText());

            // Get publisher
            JsonNode publisher = book.get("publisher");
            if (publisher == null || publisher.isNull())
                // No cover img for this book
                bookResponse.setPublisher("");
            else bookResponse.setPublisher(publisher.asText());

            // Get avgRating
            JsonNode avgRating = book.get("averageRating");
            if (avgRating == null || avgRating.isNull())
                // No avgRating for this book
                bookResponse.setAvgRating(3.0);
            else bookResponse.setAvgRating(avgRating.asDouble());

            results.add(bookResponse);
        }
        return results;
    }


    /**
     * Check whether the size parameter respects the maximum allowed
     * @param size Value to be validated
     * @return Validated int value
     */
    private int validateRecordsNumber(int size) {
        return Math.min(size, GlobalConstants.maxRecordsAdvOverview);
    }
}
