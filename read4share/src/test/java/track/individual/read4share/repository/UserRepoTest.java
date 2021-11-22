package track.individual.read4share.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import track.individual.read4share.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class UserRepoTest {

    // Arrange - Setup the code to be used
    // Act - Execute the method to be tested
    // Assert - Check if the method postcondition is as expected

    @Autowired
    private UserRepo userRepo;

    @Test
    public void saveUser() {
        // ARRANGE: Create fake user
        User user = User.builder()
                .username("testUser")
                .password("1234")
                .email("testemail@demo.com")
                .build();

        // ACT: Store the user
        userRepo.save(user);
        // ASSERT:
    }

    @Test
    public void printAllUser() {
        List<User> userList = userRepo.findAll();
        System.out.println("User list = " + userList);
    }

    @Test
    public void printUserByUsername() {
        List<User> users = userRepo.findByUsername("testUser");
        //Assert.isNull(users, "Nessun utente trovato");
        System.out.println(users);

    }

    @Test
    public void printUserByUsernameContaining() {
        List<User> users = userRepo.findByUsernameContaining("te");
        //Assert.isNull(users, "Nessun utente trovato");
        System.out.println(users);

    }

    @Test
    public void printUserByEmail() {
        User user = userRepo.getUserByEmail("demomail1@gmail.com");
        //Assert.isNull(users, "Nessun utente trovato");
        System.out.println(user.getUsername());

    }

    @Test
    public void printUsernameByEmail() {
        String username = userRepo.getUsernameByEmailNative("testemail@demo.com");
        //Assert.isNull(users, "Nessun utente trovato");
        System.out.println(username);

    }
}