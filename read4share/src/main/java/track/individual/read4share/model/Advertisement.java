package track.individual.read4share.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamedEntityGraph(name = "adv-book-graph",
        attributeNodes = { @NamedAttributeNode("book") }
)
@NamedEntityGraph(
        name = "adv-book-category-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "book", subgraph = "category-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "category-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("category")
                        }
                )
        }
)
@Entity(name = "Advertisement")
@Table(name = "adv")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adv_id")
    private Long id;
    @Column(name = "descr", nullable = false, columnDefinition = "TEXT")
    private String descr;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "ship_cost")
    private double shipCost;
    @Column(name = "publ_date", nullable = false)
    private Date publDate;
    @Column(name = "sale_date", nullable = true)
    private Date saleDate;
    @Column(name = "pic_path", nullable = true)
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
