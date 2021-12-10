package track.individual.read4share.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import track.individual.read4share.model.User;

public interface UserService extends UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * Check if a user with the specified username already exists
     * @param username Username
     * @return True if the user exists, false otherwise
     */
    boolean existsByUsername(String username);

    /**
     * Check if a user with the specified email already exists
     * @param email User email
     * @return True if the user exists, false otherwise
     */
    boolean existsByEmail(String email);


    User addUser(User user);

}
