package track.individual.read4share.model.response;

import lombok.*;

/**
 * Advertisement overview containing the main info
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvOverview {

    private String bookTitle;
    private String bookAuthor;
    private String sellerUsername;
    private String advLocation;
    private double advPrice;
    private String bookCoverUrl;
}
