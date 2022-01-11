package track.individual.read4share.dto.request;

import java.util.UUID;

public class PublishAdvRequest {
    private String bookIsbn;
    private String bookTitle;
    private String bookAuthor;
    private int bookPublYear;
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

}
