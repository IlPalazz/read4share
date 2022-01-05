package track.individual.read4share.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateChatRequest {
    @NotNull
    private UUID buyerId;
    @NotNull
    private Long advId;
}
