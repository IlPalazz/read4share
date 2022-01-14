package track.individual.read4share.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchBookRequest {

    @NotNull
    @NotBlank
    private String title;
    private String author;
}
