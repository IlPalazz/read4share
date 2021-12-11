package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.ERole;
import track.individual.read4share.model.Role;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    /**
     * Find a role by name
     * @param name Role name
     * @return Role object, Null otherwise
     */
    Optional<Role> findByName(ERole name);
}
