package track.individual.read4share.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class JwtResponse {

    private String token;
    private String username;
    private List<String> roles;

}
