package track.individual.read4share.exception.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsernameAlreadyExistsException extends RuntimeException {
    private String errorMessage;
}
