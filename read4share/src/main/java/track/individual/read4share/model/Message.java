package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Message")
@Table(name = "mess")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mess_id")
    private Long id;
    @Lob
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "timestamp", nullable = false)
    private Date timestamp;
    @Column(name = "read", nullable = false)
    private boolean read;

    /**
     * User who has sent the message
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_sender_id", referencedColumnName = "user_id")
    private User sender;

    /**
     * Advertisement related to the message
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_adv_id", referencedColumnName = "adv_id")
    private Advertisement adv;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message )) return false;
        return id != null && id.equals(((Message) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
