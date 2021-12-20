package track.individual.read4share.dto;

import track.individual.read4share.dto.response.ActiveAdvResponse;
import track.individual.read4share.dto.response.AdvOverviewResponse;
import track.individual.read4share.model.Adv;

import java.util.List;

public interface Converter {

    /**
     * Convert a List of Adv into a List of AdvOverviewResponse
     * @param advs List of Adv to convert
     * @return List of AdvOverviewResponse
     */
    List<AdvOverviewResponse> toAdvOverviewResponse(List<Adv> advs);

    /**
     * Convert an Adv object into an AdvOverviewResponse object
     * @param adv Advertisement to convert
     * @return AdvOverviewResponse object
     */
    AdvOverviewResponse toAdvOverviewResponse(Adv adv);

    /**
     * Convert a List of Adv into a List of ActiveAdvResponse
     * @param advs List of Adv to convert
     * @return List of ActiveAdvResponse
     */
    List<ActiveAdvResponse> toActiveAdvResponse(List<Adv> advs);

    /**
     * Convert an Adv object into an ActiveAdvResponse object
     * @param adv Advertisement to convert
     * @return ActiveAdvResponse object
     */
    ActiveAdvResponse toActiveAdvResponse(Adv adv);
}
