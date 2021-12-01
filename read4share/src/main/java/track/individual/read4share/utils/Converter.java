package track.individual.read4share.utils;

import track.individual.read4share.dto.AdvOverviewDTO;
import track.individual.read4share.model.Adv;

import java.util.List;

public interface Converter {

    /**
     * Convert a List of Adv into a List of AdvOverviewDTO
     * @param advs List of Adv to convert
     * @return List of AdvOverviewDTO
     */
    List<AdvOverviewDTO> convert(List<Adv> advs);
}
