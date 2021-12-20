package track.individual.read4share.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import track.individual.read4share.model.Book;
import track.individual.read4share.model.Condition;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActiveAdvResponse {
    private Long advId;
    private String advDescr;
    private double advPrice;
    private double advShipCost;
    private LocalDateTime advPublDate;
    private String advPicPath;
    private String advLocation;
    private Book book;
    private Condition condition;
    private String sellerUsername;
}
