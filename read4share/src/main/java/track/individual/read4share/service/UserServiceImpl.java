package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import track.individual.read4share.model.User;
import track.individual.read4share.repository.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
