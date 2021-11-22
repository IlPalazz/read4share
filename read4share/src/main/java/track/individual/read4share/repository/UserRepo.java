package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    // Search users with a username that contains the specified string
    List<User> findByUsernameContaining(String username);

    // Return not null records
    List<User> findByEmailNotNull();

    // JPQL Queries: custom queries based on classes rather than DB tables
    @Query("select u from User u where u.email = ?1")
    User getUserByEmail(String email);

    @Query("select u.username from User u where u.email = ?1")
    String getUserUsernameByEmail(String email);

    // Native query
    @Query(
            value = "select u.email_addr from users u where u.email_addr= ?1",
            nativeQuery = true
    )
    String getUsernameByEmailNative(String email);

    // Update records
    @Modifying
    @Transactional
    @Query(
            value = "update users set username = ?1 where email_addr = ?2",
            nativeQuery = true
    )
    int updateUsernameByEmail(String username, String email);
}
