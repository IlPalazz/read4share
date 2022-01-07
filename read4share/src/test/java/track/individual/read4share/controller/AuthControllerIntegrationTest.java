package track.individual.read4share.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apiguardian.api.API;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import track.individual.read4share.dto.request.RegisterRequest;
import track.individual.read4share.dto.response.HttpMessageResponse;
import track.individual.read4share.model.ERole;
import track.individual.read4share.model.Role;
import track.individual.read4share.model.User;
import track.individual.read4share.service.RoleService;
import track.individual.read4share.service.UserService;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static track.individual.read4share.controller.ResponseBodyMatcher.responseBody;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthControllerIntegrationTest {

    private final String API_URL = "http://localhost:8080/api/auth";
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @DisplayName("It should return a 400 when a request input field is invalid")
    public void invalidInputTest() throws Exception {
        // ARRANGE
        // Create an invalid registration request
        RegisterRequest invalidRequest = RegisterRequest.builder()
                .email(null).password(null).username(null).build();

        // Expected response
        HttpMessageResponse expectedResponse = new HttpMessageResponse("Invalid request body fields!");

        // ACT
        mockMvc.perform(post(API_URL + "/register")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(invalidRequest)))
                // ASSERT
                .andExpect(status().isBadRequest())
                .andExpect(responseBody().containsObjectAsJson(expectedResponse, HttpMessageResponse.class));
    }

    @Test
    @DisplayName("It should successfully register a new user")
    @Sql(statements = "INSERT INTO role (role_id, name) VALUES ('1', 'ROLE_USER')",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Transactional
    public void registrationSuccessTest() throws Exception {
        // ARRANGE
         //Create a new User
        User user = User.builder()
                .id(UUID.randomUUID())
                .email("testemail@test.com")
                .username("test_user")
                .password("12345")
                .build();
        System.out.println("user = " + objectMapper.writeValueAsString(user));

        // ACT / ASSERT
        this.mockMvc.perform(post(API_URL + "/register")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("It should fail due to an already existing username")
    @Sql(statements = "INSERT INTO role (role_id, name) VALUES ('1', 'ROLE_USER')",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Transactional
    public void registrationFailUsernameTest() throws Exception {
        // ARRANGE
        // Register a new user
        Set<Role> roles = new HashSet<>();
        roles.add(this.roleService.findByName(ERole.ROLE_USER));
        User user = User.builder()
                .id(UUID.randomUUID())
                .email("testemail@test.com")
                .username("test_user")
                .password("12345")
                .roles(roles)
                .build();
        this.userService.registerUser(user);

        // Expected response
        HttpMessageResponse expectedResponse = new HttpMessageResponse("Error: Username " + user.getUsername() +
                " already exists! Choose another one");

        // ACT
        // Try to register a new user with the same username
        mockMvc.perform(post(API_URL + "/register")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isConflict())
                // ASSERT
                .andExpect(responseBody().containsObjectAsJson(expectedResponse, HttpMessageResponse.class));
    }

    @Test
    @DisplayName("It should fail due to an already existing email")
    @Sql(statements = "INSERT INTO role (role_id, name) VALUES ('1', 'ROLE_USER')",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Transactional
    public void registrationFailEmailTest() throws Exception {
        // ARRANGE
        // Register a new user
        Set<Role> roles = new HashSet<>();
        roles.add(this.roleService.findByName(ERole.ROLE_USER));
        User user = User.builder()
                .id(UUID.randomUUID())
                .email("testemail@test.com")
                .username("test_user")
                .password("12345")
                .roles(roles)
                .build();
        this.userService.registerUser(user);

        // Change the username to verify the exception on the email
        user.setUsername("another_user");

        // Expected HTTP response
        HttpMessageResponse expectedResponse = new HttpMessageResponse("Error: A user with the specified email already exists!");

        // ACT
        // Try to register a new user with the same email
        mockMvc.perform(post(API_URL + "/register")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isConflict())
                // ASSERT
                .andExpect(responseBody().containsObjectAsJson(expectedResponse, HttpMessageResponse.class));
//
    }


}
