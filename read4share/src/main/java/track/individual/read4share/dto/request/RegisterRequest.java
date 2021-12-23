package track.individual.read4share.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotNull
    @NotBlank
    @Size(min = 5, max = 64)
    private String username;
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Size(min = 5, max = 64)
    private String password;
}
