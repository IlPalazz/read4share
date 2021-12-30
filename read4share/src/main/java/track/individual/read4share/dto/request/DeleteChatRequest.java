package track.individual.read4share.dto.request;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteChatRequest {
    private UUID senderId;
    private UUID recipientId;
    private Long advId;
}
