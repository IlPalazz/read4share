package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import track.individual.read4share.exception.ItemNotFoundException;
import track.individual.read4share.model.User;
import track.individual.read4share.repository.UserRepo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User getById(Long id) {

        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) throw new ItemNotFoundException("User with specified id: " + id + " not found!");
        return user.get();
    }

    @Override
    public User getByUsername(String username) throws ItemNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isEmpty()) throw new ItemNotFoundException("User with specified username: " + username + " not found!");
        return user.get();
    }
}
