package track.individual.read4share.model;

import lombok.*;

import javax.persistence.*;
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
    private String name;

}
