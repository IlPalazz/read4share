package track.individual.read4share.service;

import track.individual.read4share.model.User;
import track.individual.read4share.exception.ItemNotFoundException;

public interface UserService {

    /**
     * Return a particular user
     * @param id User id
     * @return User with the specified id
     * @exception ItemNotFoundException Threw if user is not found
     */
    User getById(Long id) throws ItemNotFoundException;

    /**
     * Return a particular user
     * @param username Username
     * @return User with the specified username
     * @exception ItemNotFoundException Threw if user is not found
     */
    User getByUsername(String username) throws ItemNotFoundException;

}
