package track.individual.read4share.exception.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RoleNotFoundException extends RuntimeException {
    private String errorMessage;
}
