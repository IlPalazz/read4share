package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import track.individual.read4share.dto.response.JwtResponse;
import track.individual.read4share.dto.response.UserDetailsResponse;
import track.individual.read4share.exception.ItemNotFoundException;
import track.individual.read4share.model.User;
import track.individual.read4share.repository.UserRepo;
import track.individual.read4share.security.UserDetailsImpl;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with username: " + username + " not found"));
        return UserDetailsImpl.build(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public User registerUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public UserDetailsResponse getUserDetails() {
        // Get user details
        UserDetailsImpl userDetails =
                (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Turn roles into a List of String
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return UserDetailsResponse.builder()
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .roles(roles)
                .build();
    }

    @Override
    public User getById(UUID id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty())
            throw new ItemNotFoundException("User with specified id doesn not exist!");
        return user.get();
    }

}
