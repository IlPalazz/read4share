package track.individual.read4share.service;

import org.springframework.http.ResponseEntity;
import track.individual.read4share.model.User;

import java.util.List;

public interface UserService {

    /**
     * Return a particular user
     * @param id
     * @return User with the specified id, Null otherwise
     */
    User getUser(Long id);

    /**
     * Return a particular user
     * @param username
     * @return User with the specified username, Null otherwise
     */
    User getUserByUsername(String username);

    /**
     * Add a new user to the system
     * @param user
     */
    User addUser(User user);

    /**
     * Return all the users inside the DB
     * @return
     */
    List<User> getUsers();
}
