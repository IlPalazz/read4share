package track.individual.read4share.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Book")
@Table(name = "book", uniqueConstraints = @UniqueConstraint(
        name = "book_isbn_unique", columnNames = "isbn"))
@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    @Column(name = "isbn", length = 13)
    private String isbn;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "publ_date", nullable = false)
    private LocalDateTime publDate;
    @Column(name = "publisher", nullable = false)
    private String publisher;
    @Column(name = "lang", nullable = false)
    private String language;
    @Column(name = "cover_url", nullable = false)
    private String coverUrl;
    @Column(name = "avg_rating", nullable = false)
    private double avgRating;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cat_id", referencedColumnName = "cat_id")
    private Category category;
}
