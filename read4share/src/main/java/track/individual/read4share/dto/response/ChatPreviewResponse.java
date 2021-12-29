package track.individual.read4share.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatPreviewResponse {
    private UUID recipientId;
    private String recipientUsername;
    private String bookTitle;
    private String bookCoverUrl;
    private Long advId;
}
