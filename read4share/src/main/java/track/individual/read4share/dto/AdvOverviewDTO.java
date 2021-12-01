package track.individual.read4share.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Advertisement overview containing the main info
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvOverviewDTO {

    private String bookTitle;
    private String bookAuthor;
    private String sellerUsername;
    private String advLocation;
    private double advPrice;
    private String bookCoverUrl;
}
