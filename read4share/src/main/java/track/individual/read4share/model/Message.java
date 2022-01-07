package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@NamedEntityGraph(
        name = "graph.MessageAdvBookUser",
        attributeNodes = {
                @NamedAttributeNode(value = "sender"),
                @NamedAttributeNode(value = "adv", subgraph = "subgraph.book"),
                @NamedAttributeNode(value = "adv", subgraph = "subgraph.user"),
        },
        subgraphs = {
                @NamedSubgraph(name = "subgraph.user", attributeNodes = @NamedAttributeNode(value = "seller")),
                @NamedSubgraph(name = "subgraph.book", attributeNodes = @NamedAttributeNode(value = "book")),
        }
)
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
    @Column(name = "text", nullable = false)
    @Size(min = 1, max = 255)
    @NotNull
    @NotBlank
    private String text;
    @Column(name = "timestamp", nullable = false)
    @NotNull
    private LocalDateTime timestamp;
    @Column(name = "read", nullable = false)
    @NotNull
    private boolean read;

    /**
     * User who has sent the message
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_sender_id", referencedColumnName = "user_id")
    private User sender;

    /**
     * User who has received the message
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_recipient_id", referencedColumnName = "user_id")
    private User recipient;

    /**
     * Advertisement related to the message
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_adv_id", referencedColumnName = "adv_id")
    private Adv adv;

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
