package track.individual.read4share.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class ItemAlreadyExistingException extends RuntimeException{

    private String errorMessage;

}