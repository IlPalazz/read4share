package track.individual.read4share.service;

import track.individual.read4share.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Return a particular user
     * @param id User id
     * @return User with the specified id, Null otherwise
     */
    Optional<User> getById(Long id);

    /**
     * Return a particular user
     * @param username Username
     * @return User with the specified username, Null otherwise
     */
    Optional<User> getByUsername(String username);

}
