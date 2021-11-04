package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mess")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "timestamp", nullable = false)
    private Date timestamp;
    @Column(name = "seller_id")
    private Long sellerId;     // FK
    @Column(name = "buyer_id")
    private Long buyerId;      // FK
    @Column(name = "adv_id")
    private Long advId;        // Fk
}
