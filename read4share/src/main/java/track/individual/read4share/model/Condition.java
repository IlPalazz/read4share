package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "condition")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Condition {
    @Id
    @Column(name = "code")
    private Conditions code;
    @Column(name = "pen_underln", nullable = false)
    private boolean pen_underln;
    @Column(name = "penc_underln", nullable = false)
    private boolean penc_underln;
    @Column(name = "highl_underln", nullable = false)
    private boolean highl_underln;
}
