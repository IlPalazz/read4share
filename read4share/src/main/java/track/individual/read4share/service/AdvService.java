package track.individual.read4share.service;

import track.individual.read4share.model.Advertisement;

import java.util.List;

public interface AdvService {

    /**
     * Most recently posted advertisements
     * @return List of Advertisements
     */
    List<Advertisement> getLatest();

    /**
     * Advertisements with the best rated books
     * @return List of Advertisements
     */
    List<Advertisement> getBestRating();

    /**
     * Latest free advertisements
     * @return List of Advertisements
     */
    List<Advertisement> getFree();

    /**
     * Latest advertisements with no delivery fees
     * @return List of Advertisements
     */
    List<Advertisement> getFreeDel();

    /**
     * Advertisements with books marked as new
     * @return List of Advertisements
     */
    List<Advertisement> getAsNew();

    /**
     * Advertisements with books that belong to a specific category
     * @return List of Advertisements
     */
    List<Advertisement> getByCategoryId(Long id);
}
