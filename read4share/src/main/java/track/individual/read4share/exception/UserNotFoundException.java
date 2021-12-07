package track.individual.read4share.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserNotFoundException extends RuntimeException {

    private String message;
}
