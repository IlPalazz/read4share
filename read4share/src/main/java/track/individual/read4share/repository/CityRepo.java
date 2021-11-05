package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import track.individual.read4share.model.City;

public interface CityRepo extends JpaRepository<City, Long> {
}
