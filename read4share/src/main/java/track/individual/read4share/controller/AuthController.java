package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.dto.request.LoginRequest;
import track.individual.read4share.dto.request.RegisterRequest;
import track.individual.read4share.dto.response.HttpMessageResponse;
import track.individual.read4share.dto.response.JwtResponse;
import track.individual.read4share.exception.auth.EmailAlreadyExistsException;
import track.individual.read4share.exception.auth.UsernameAlreadyExistsException;
import track.individual.read4share.model.ERole;
import track.individual.read4share.model.Role;
import track.individual.read4share.model.User;
import track.individual.read4share.security.jwt.JwtUtils;
import track.individual.read4share.service.UserService;
import track.individual.read4share.security.UserDetailsImpl;
import track.individual.read4share.service.RoleService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController()
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final RoleService roleService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {

        // Username check
        if (userService.existsByUsername(registerRequest.getUsername()))
            throw new UsernameAlreadyExistsException("Error: Username " + registerRequest.getUsername() +
                    " already exists! Choose another one");

        // Email check
        if (userService.existsByEmail(registerRequest.getEmail()))
            throw new EmailAlreadyExistsException("Error: A user with the specified email already exists!");

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(ERole.ROLE_USER));

        // Create new user's account
        User user = User.builder()
                .id(UUID.randomUUID())
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(encoder.encode(registerRequest.getPassword()))
                .roles(roles)
                .build();
        // Save the user
        userService.addUser(user);

        return ResponseEntity.ok(new HttpMessageResponse("User registered successfully!"));
    }

    @PostMapping("/registerAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequest registerRequest) { //TODO: Implement admin reg
//
//           else {
//            strRoles.forEach(role -> {
//                if (role.equalsIgnoreCase("admin")) {
//                    Role adminRole = roleRepo.findByName(ERole.ROLE_ADMIN)
//                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                    roles.add(adminRole);
//
//                } else {
//                    Role userRole = roleRepo.findByName(ERole.ROLE_USER)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                    roles.add(userRole);
//                }
//            });
//        }
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        // Get user details
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(JwtResponse.builder()
                .token(jwt)
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .roles(roles)
                .build());
    }

    @GetMapping("/details")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUserDetails() {
        return ResponseEntity.ok().body(userService.getUserDetails());
    }

}
