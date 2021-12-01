package track.individual.read4share.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Advertisement overview containing the main info
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvOverviewDTO {

    private String bookTitle;
    private String bookAuthor;
    private String sellerUsername;
    private String advLocation;
    private LocalDateTime advPublDate;
    private double advPrice;
    private String bookCoverUrl;
}
