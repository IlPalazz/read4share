package track.individual.read4share.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemNotFoundException extends RuntimeException {
    private String errorMessage;
}
