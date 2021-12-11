package track.individual.read4share.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min = 13, max = 13)
    private String isbn;
    @Column(name = "title", nullable = false)
    @Size(min = 1, max = 255)
    @NotNull
    @NotBlank
    private String title;
    @Column(name = "author", nullable = false)
    @Size(min = 1, max = 255)
    @NotNull
    @NotBlank
    private String author;
    @Column(name = "publ_date", nullable = false)
    private LocalDateTime publDate;
    @Column(name = "publisher", nullable = false)
    private String publisher;
    @Column(name = "lang", nullable = false)
    @Size(min = 1, max = 255)
    @NotNull
    @NotBlank
    private String language;
    @Column(name = "cover_url", nullable = false)
    @NotNull
    @NotBlank
    private String coverUrl;
    @Column(name = "avg_rating", nullable = false)
    @NotNull
    private double avgRating;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cat_id", referencedColumnName = "cat_id")
    private Category category;
}
