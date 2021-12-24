package track.individual.read4share.dto;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import track.individual.read4share.dto.response.AdvDetailsResponse;
import track.individual.read4share.dto.response.AdvOverviewResponse;
import track.individual.read4share.model.Adv;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class ConverterImpl implements Converter {

    @Override
    public List<AdvOverviewResponse> toAdvOverviewResponse(List<Adv> advs) {
        List<AdvOverviewResponse> listDto = new ArrayList<>();
        for (Adv adv : advs)
            listDto.add(this.toAdvOverviewResponse(adv));
        return listDto;
    }

    @Override
    public AdvOverviewResponse toAdvOverviewResponse(Adv adv) {
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

    @Override
    public List<AdvDetailsResponse> toActiveAdvResponse(List<Adv> advs) {
        List<AdvDetailsResponse> listDto = new ArrayList<>();
        for (Adv adv : advs)
            listDto.add(this.toActiveAdvResponse(adv));
        return listDto;
    }

    @Override
    public AdvDetailsResponse toActiveAdvResponse(Adv adv) {
        return AdvDetailsResponse.builder()
                .advId(adv.getId())
                .advDescr(adv.getDescr())
                .advPrice(adv.getPrice())
                .advShipCost(adv.getShipCost())
                .advPublDate(adv.getPublDate())
                .advSaleDate(adv.getSaleDate())
                .advPicPath(adv.getPicPath())
                .advLocation(adv.getCity())
                .book(adv.getBook())
                .condition(adv.getCondition())
                .sellerUsername(adv.getSeller().getUsername())
                .build();
    }

}
