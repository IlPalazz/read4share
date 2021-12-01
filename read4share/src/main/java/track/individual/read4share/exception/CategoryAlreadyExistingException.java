package track.individual.read4share.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CategoryAlreadyExistingException extends RuntimeException{

    private String message;

}