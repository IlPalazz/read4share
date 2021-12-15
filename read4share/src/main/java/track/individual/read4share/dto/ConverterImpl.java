package track.individual.read4share.dto;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import track.individual.read4share.dto.response.AdvOverviewResponse;
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
    private AdvOverviewResponse fromAdvToAdvOverviewDTO(Adv adv) {
        return AdvOverviewResponse.builder()
                .advId(adv.getId())
                .bookTitle(adv.getBook().getTitle())
                .bookAuthor(adv.getBook().getAuthor())
                .sellerUsername(adv.getSeller().getUsername())
                .advLocation(adv.getCity().getName())
                .advPrice(adv.getPrice())
                .bookCoverUrl(adv.getBook().getCoverUrl())
                .advPublDate(adv.getPublDate())
                .build();
    }

    public List<AdvOverviewResponse> convert(List<Adv> advs) {
        List<AdvOverviewResponse> listDto = new ArrayList<>();
        for (Adv adv : advs)
            listDto.add(this.fromAdvToAdvOverviewDTO(adv));
        return listDto;
    }

}
