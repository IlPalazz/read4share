package track.individual.read4share.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotNull
    @NotBlank
    @Size(min = 5, max = 64)
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 5, max = 64)
    private String password;
}
