package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    @Query("select COUNT(u) from User u")
    int getTotalNumber();


//    // Update records
//    @Modifying
//    @Transactional
//    @Query(
//            value = "update users set username = ?1 where email_addr = ?2",
//            nativeQuery = true
//    )
//    int updateUsernameByEmail(String username, String email);
}
