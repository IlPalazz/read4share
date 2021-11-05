package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import track.individual.read4share.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
