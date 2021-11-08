package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Advertisement")
@Table(name = "adv")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {
    @Id
    @Column(name = "adv_id")
    private Long id;
    @Column(name = "descr", nullable = false)
    private String descr;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "ship_cost")
    private double shipCost;
    @Column(name = "publ_date", nullable = false)
    private Date publDate;
    @Column(name = "pic_path", nullable = false)
    private String picPath;

    /**
     * Advertisement book
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_book_isbn", referencedColumnName = "isbn")
    private Book book;

    /**
     * Book conditions
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cond_code", referencedColumnName = "cond_code")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Advertisement )) return false;
        return id != null && id.equals(((Advertisement) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
