package track.individual.read4share.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Category")
@Table(name = "category",
        uniqueConstraints = @UniqueConstraint(
                name="category_name_unique", columnNames = "name")
)
@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long id;
    @Column(name = "name", nullable = false)
    @Size(min = 1, max = 255)
    @NotBlank
    @NotNull
    private String name;

}
