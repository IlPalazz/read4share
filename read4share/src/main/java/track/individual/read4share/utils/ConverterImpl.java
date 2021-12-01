package track.individual.read4share.utils;

import lombok.NoArgsConstructor;
import track.individual.read4share.dto.AdvOverviewDTO;
import track.individual.read4share.model.Adv;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ConverterImpl implements Converter {

    /**
     * Convert an Adv object into an AdvOverviewDTO object
     * @param adv Advertisement to convert
     * @return AdvOverviewDTO object
     */
    private AdvOverviewDTO fromAdvToAdvOverviewDTO(Adv adv) {
        return AdvOverviewDTO.builder()
                .bookTitle(adv.getBook().getTitle())
                .bookAuthor(adv.getBook().getAuthor())
                .sellerUsername(adv.getSeller().getUsername())
                .advLocation(adv.getCity().getName())
                .advPrice(adv.getPrice())
                .bookCoverUrl(adv.getBook().getCoverUrl())
                .advPublDate(adv.getPublDate())
                .build();
    }

    public List<AdvOverviewDTO> convert(List<Adv> advs) {
        List<AdvOverviewDTO> listDto = new ArrayList<>();
        for (Adv adv : advs)
            listDto.add(this.fromAdvToAdvOverviewDTO(adv));
        return listDto;
    }

}
