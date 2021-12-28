package track.individual.read4share.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatPreviewResponse {
    private String recipientId;
    private String recipientUsername;
    private String bookTitle;
    private String bookCoverUrl;
    private Long advId;
}
