package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "City")
@Table(name = "city",
        uniqueConstraints = @UniqueConstraint(
                name = "city_name_unique", columnNames = "name"
        )
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;
    @Column(name = "name", nullable = false)
    @Size(min = 1, max = 255)
    @NotBlank
    @NotNull
    private String name;
}
