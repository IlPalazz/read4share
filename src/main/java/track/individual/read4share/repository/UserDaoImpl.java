package track.individual.read4share.repository;

import org.springframework.stereotype.Repository;
import track.individual.read4share.model.User;

import java.util.ArrayList;

@Repository
public class UserDaoImpl implements UserDao{
    private static ArrayList<User> users;

    public UserDaoImpl() {
        users = new ArrayList<>();
        // Fill with fake data
        users.add(new User("user1", "demoUS1@gmail.com"));
        users.add(new User("user2", "demoUS2@gmail.com"));
    }

    @Override
    public void AddUser(User user) {
        users.add(user);
    }

    @Override
    public User GetUser(String username) {
        for (User user : users)
            if (user.getUsername().equals(username))
                return user;
        return null;
    }

    @Override
    public void DeleteUser(String username) {
        for (User user : users)
            if (user.getUsername().equals(username))
                users.remove(user);
    }
}
