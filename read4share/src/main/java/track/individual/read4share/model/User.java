package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "username_unique", columnNames = "username"),
        @UniqueConstraint(name = "email_unique", columnNames = "email_addr")
})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "passw", nullable = false)
    private String password;
    @Column(name = "email_addr", nullable = false)
    private String email;
}

