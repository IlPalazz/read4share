package track.individual.read4share.service;

import track.individual.read4share.dto.AdvOverviewDTO;

import java.util.List;

public interface AdvService {

    /**
     * Most recently posted advertisements
     * @param size Number of elements to return to the client
     * @return List of Advertisements Overview
     */
    List<AdvOverviewDTO> getLatest(int size);

    /**
     * Advertisements with the best rated books
     * @param size Number of elements to return to the client
     * @return List of Advertisements Overview
     */
    List<AdvOverviewDTO> getBestRating(int size);

    /**
     * Latest free advertisements
     * @param size Number of elements to return to the client
     * @return List of Advertisements Overview
     */
    List<AdvOverviewDTO> getFree(int size);

    /**
     * Latest advertisements with no delivery fees
     * @param size Number of elements to return to the client
     * @return List of Advertisements Overview
     */
    List<AdvOverviewDTO> getFreeDel(int size);

    /**
     * Advertisements with books marked as new
     * @param size Number of elements to return to the client
     * @return List of Advertisements Overview
     */
    List<AdvOverviewDTO> getAsNew(int size);

    /**
     * Advertisements with books that belong to a specific category
     * @return List of Advertisements Overview
     */
    List<AdvOverviewDTO> getByCategoryId(Long id, int page, int size);
}
