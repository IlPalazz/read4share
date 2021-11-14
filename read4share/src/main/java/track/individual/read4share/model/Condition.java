package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Condition")
@Table(name = "condition")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cond_id")
    private Long id;
    @Column(name = "cond_code", length = 2)
    @Enumerated(EnumType.STRING)
    private Conditions code;
    @Column(name = "pen_underln", nullable = false)
    private boolean pen_underln;
    @Column(name = "penc_underln", nullable = false)
    private boolean penc_underln;
    @Column(name = "highl_underln", nullable = false)
    private boolean highl_underln;
}
