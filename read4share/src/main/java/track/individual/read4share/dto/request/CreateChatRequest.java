package track.individual.read4share.dto.request;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateChatRequest {
    private UUID buyerId;
    private Long advId;
}
