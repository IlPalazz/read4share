package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
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
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
}
