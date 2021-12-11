package track.individual.read4share.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import track.individual.read4share.model.Role;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDetailsResponse {
    private UUID id;
    private String username;
    private String email;
    private List<String> roles;
}
