package track.individual.read4share.utils;

import track.individual.read4share.dto.AdvOverviewDTO;
import track.individual.read4share.model.Adv;

import java.util.ArrayList;
import java.util.List;

public class AdvConverter {

    /**
     * Convert an Adv object to an AdvOverviewDTO object
     * @param adv Advertisement to convert
     * @return AdvOverview object
     */
    private static AdvOverviewDTO convert(Adv adv) {
        return AdvOverviewDTO.builder()
                .bookTitle(adv.getBook().getTitle())
                .bookAuthor(adv.getBook().getAuthor())
                .sellerUsername(adv.getSeller().getUsername())
                .advLocation(adv.getCity().getName())
                .advPrice(adv.getPrice())
                .bookCoverUrl(adv.getBook().getCoverUrl())
                .build();
    }

    public static List<AdvOverviewDTO> convert(List<Adv> advs) {
        List<AdvOverviewDTO> listDto = new ArrayList<>();
        for (Adv adv : advs)
            listDto.add(AdvConverter.convert(adv));
        return listDto;
    }

}
