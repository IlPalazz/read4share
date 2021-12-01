package track.individual.read4share.dto;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import track.individual.read4share.dto.response.AdvOverviewResp;
import track.individual.read4share.model.Adv;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class ConverterImpl implements Converter {

    /**
     * Convert an Adv object into an AdvOverviewResp object
     * @param adv Advertisement to convert
     * @return AdvOverviewResp object
     */
    private AdvOverviewResp fromAdvToAdvOverviewDTO(Adv adv) {
        return AdvOverviewResp.builder()
                .bookTitle(adv.getBook().getTitle())
                .bookAuthor(adv.getBook().getAuthor())
                .sellerUsername(adv.getSeller().getUsername())
                .advLocation(adv.getCity().getName())
                .advPrice(adv.getPrice())
                .bookCoverUrl(adv.getBook().getCoverUrl())
                .advPublDate(adv.getPublDate())
                .build();
    }

    public List<AdvOverviewResp> convert(List<Adv> advs) {
        List<AdvOverviewResp> listDto = new ArrayList<>();
        for (Adv adv : advs)
            listDto.add(this.fromAdvToAdvOverviewDTO(adv));
        return listDto;
    }

}
