package track.individual.read4share.dto;

import track.individual.read4share.dto.response.AdvOverviewResp;
import track.individual.read4share.model.Adv;

import java.util.List;

public interface Converter {

    /**
     * Convert a List of Adv into a List of AdvOverviewResp
     * @param advs List of Adv to convert
     * @return List of AdvOverviewResp
     */
    List<AdvOverviewResp> convert(List<Adv> advs);
}
