package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import track.individual.read4share.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query("select cat from Category cat order by cat.name asc")
    List<Category> findAll();

    Optional<Category> findByNameIgnoreCase(String name);
}
