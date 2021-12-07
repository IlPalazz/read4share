package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import track.individual.read4share.exception.UserNotFoundException;
import track.individual.read4share.model.User;
import track.individual.read4share.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User getById(Long id) {

        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException("User with specified id: " + id + " not found!");
        return user.get();
    }

    @Override
    public User getByUsername(String username) throws UserNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isEmpty()) throw new UserNotFoundException("User with specified username: " + username + " not found!");
        return user.get();
    }
}
