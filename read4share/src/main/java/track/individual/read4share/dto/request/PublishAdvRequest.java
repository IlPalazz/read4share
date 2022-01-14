package track.individual.read4share.dto.request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublishAdvRequest {
    private String bookIsbn;
    private String bookTitle;
    private String bookAuthor;
    private LocalDateTime bookPublDate;
    private String bookPublisher;
    private String bookLanguage;
    private String bookCoverUrl;
    private String bookCategory;
    private double bookAvgRating;
    private String advDescr;
    private double advPrice;
    private double advShipCost;
    // private Long locationId;
    private UUID sellerId;
    private String condCode;
    private boolean condPen;
    private boolean condPencil;
    private boolean condHighl;

}
