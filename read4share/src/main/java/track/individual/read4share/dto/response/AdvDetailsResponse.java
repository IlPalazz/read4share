package track.individual.read4share.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import track.individual.read4share.model.Book;
import track.individual.read4share.model.City;
import track.individual.read4share.model.Condition;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvDetailsResponse {
    private Long advId;
    private String advDescr;
    private double advPrice;
    private double advShipCost;
    private LocalDateTime advPublDate;
    private LocalDateTime advSaleDate;
    private String advPicPath;
    private City advLocation;
    private Book book;
    private Condition condition;
    private String sellerUsername;
}
