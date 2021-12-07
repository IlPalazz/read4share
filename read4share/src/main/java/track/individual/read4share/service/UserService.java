package track.individual.read4share.service;

import track.individual.read4share.exception.UserNotFoundException;
import track.individual.read4share.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Return a particular user
     * @param id User id
     * @return User with the specified id
     * @exception UserNotFoundException Threw if user is not found
     */
    User getById(Long id) throws UserNotFoundException;

    /**
     * Return a particular user
     * @param username Username
     * @return User with the specified username
     * @exception UserNotFoundException Threw if user is not found
     */
    User getByUsername(String username) throws UserNotFoundException;

}
