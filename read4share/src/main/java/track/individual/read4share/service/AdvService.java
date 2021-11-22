package track.individual.read4share.service;

import track.individual.read4share.model.response.AdvOverview;

import java.util.List;

public interface AdvService {

    /**
     * Most recently posted advertisements
     * @return List of Advertisements
     */
    List<AdvOverview> getLatest();

    /**
     * Advertisements with the best rated books
     * @return List of Advertisements
     */
    List<AdvOverview> getBestRating();

    /**
     * Latest free advertisements
     * @return List of Advertisements
     */
    List<AdvOverview> getFree();

    /**
     * Latest advertisements with no delivery fees
     * @return List of Advertisements
     */
    List<AdvOverview> getFreeDel();

    /**
     * Advertisements with books marked as new
     * @return List of Advertisements
     */
    List<AdvOverview> getAsNew();

    /**
     * Advertisements with books that belong to a specific category
     * @return List of Advertisements
     */
    List<AdvOverview> getByCategoryId(Long id);
}
