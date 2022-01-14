package track.individual.read4share.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchBookResponse {
    private String isbn;
    private String title;
    private String author;
    private LocalDateTime publDate;
    private String publisher;
    private String language;
    private String coverUrl;
    private String category;
    private double avgRating;
}
