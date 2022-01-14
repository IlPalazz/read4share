package track.individual.read4share.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GBooksParseException extends RuntimeException {
    private String errorMessage;
}
