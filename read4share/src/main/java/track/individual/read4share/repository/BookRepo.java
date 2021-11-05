package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import track.individual.read4share.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
}
