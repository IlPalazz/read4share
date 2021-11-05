package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
