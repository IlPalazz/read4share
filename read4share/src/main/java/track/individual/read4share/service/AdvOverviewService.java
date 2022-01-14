package track.individual.read4share.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import track.individual.read4share.dto.response.AdvOverviewResponse;
import track.individual.read4share.dto.response.SearchBookResponse;

import java.util.List;

public interface AdvOverviewService {

    /**
     * Most recently posted advertisements
     * @param size Number of elements to return to the client
     * @return List of Advertisements Overview
     */
    List<AdvOverviewResponse> getLatest(int size);

    /**
     * Advertisements with the best rated books
     * @param size Number of elements to return to the client
     * @return List of Advertisements Overview
     */
    List<AdvOverviewResponse> getBestRating(int size);

    /**
     * Latest free advertisements
     * @param size Number of elements to return to the client
     * @return List of Advertisements Overview
     */
    List<AdvOverviewResponse> getFree(int size);

    /**
     * Latest advertisements with no delivery fees
     * @param size Number of elements to return to the client
     * @return List of Advertisements Overview
     */
    List<AdvOverviewResponse> getFreeDel(int size);

    /**
     * Advertisements with books marked as new
     * @param size Number of elements to return to the client
     * @return List of Advertisements Overview
     */
    List<AdvOverviewResponse> getAsNew(int size);

    /**
     * Advertisements with books that belong to a specific category
     * @return List of Advertisements Overview
     */
    List<AdvOverviewResponse> getByCategoryId(Long id, int page, int size);

    /**
     * List of books retrieved from the GBooks API
     * @param title Book's title
     * @param author Book's author
     * @return List of SearchBookResponse
     */
    List<SearchBookResponse> getBookOverview(String title, String author);
}
