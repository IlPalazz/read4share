package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.Book;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    Optional<Book> findBookByIsbn(String isbn);
}
