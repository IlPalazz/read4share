package track.individual.read4share.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


@Entity(name = "Adv")
@Table(name = "adv")
@NamedEntityGraph(
        name = "graph.AdvUserCityBookCategoryCondition",
        attributeNodes = {
                @NamedAttributeNode(value = "seller"), //subgraph = "subgraph.seller"),
                @NamedAttributeNode(value = "city"),
                @NamedAttributeNode(value = "condition"),
                @NamedAttributeNode(value = "book", subgraph = "subgraph.book")
        },
        subgraphs = {
                @NamedSubgraph(name = "subgraph.book", attributeNodes = @NamedAttributeNode(value = "category")),
                //@NamedSubgraph(name = "subgraph.seller", attributeNodes = @NamedAttributeNode(value = "username"))
        }
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Adv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adv_id")
    private Long id;
    @Column(name = "descr", nullable = false, columnDefinition = "TEXT")
    @Size(max = 500)
    @NotNull
    private String descr;
    @Column(name = "price", nullable = false)
    @NotNull
    private double price;
    @Column(name = "ship_cost")
    @NotNull
    private double shipCost;
    @Column(name = "publ_date", nullable = false)
    @NotNull
    private LocalDateTime publDate;
    @Column(name = "sale_date")
    private LocalDateTime saleDate;
    @Column(name = "pic_path")
    private String picPath;

    /**
     * Advertisement book
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_book_id", referencedColumnName = "book_id")
    private Book book;

    /**
     * Book conditions
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cond_id", referencedColumnName = "cond_id")
    private Condition condition;

    /**
     * Location of the advertisement
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_city_id", referencedColumnName = "city_id")
    private City city;

    /**
     * Advertisement seller
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_seller_id", referencedColumnName = "user_id")
    private User seller;

    /**
     * List of messages related to the advertisement
     */
    @OneToMany(mappedBy = "adv",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Message> messages;

    // Methods used to sync both sides of the bidirectional association
    public void addMessage(Message mess) {
        messages.add(mess);
        mess.setAdv(this);
    }

    public void removeMessage(Message mess) {
        messages.remove(mess);
        mess.setAdv(null);
    }
}
