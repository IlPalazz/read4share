package track.individual.read4share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adv")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {
    @Id
    @Column(name = "id")
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

    @Column(name = "book_id")
    private String bookId;          // FK Book
    @Column(name = "condition_id")
    private String conditionId;     // FK Condition
    @Column(name = "city_id")
    private Long cityId;            // FK City
    @Column(name = "user_id")
    private Long userId;            // FK User
}
