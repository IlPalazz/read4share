package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByUsernameIgnoreCase(String username);

    Optional<User> findByUsernameIgnoreCase(String username);

    Optional<User> findById(Long id);


//    // Update records
//    @Modifying
//    @Transactional
//    @Query(
//            value = "update users set username = ?1 where email_addr = ?2",
//            nativeQuery = true
//    )
//    int updateUsernameByEmail(String username, String email);
}
