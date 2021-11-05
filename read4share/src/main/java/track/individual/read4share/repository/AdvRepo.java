package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import track.individual.read4share.model.Advertisement;

public interface AdvRepo extends JpaRepository<Advertisement, Long> {
}
