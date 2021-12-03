package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.dto.request.LoginRequest;
import track.individual.read4share.dto.request.RegisterRequest;
import track.individual.read4share.dto.response.JwtResponse;
import track.individual.read4share.dto.response.MessageResponse;
import track.individual.read4share.model.ERole;
import track.individual.read4share.model.Role;
import track.individual.read4share.model.User;
import track.individual.read4share.repository.RoleRepo;
import track.individual.read4share.repository.UserRepo;
import track.individual.read4share.security.jwt.JwtUtils;
import track.individual.read4share.security.service.UserDetailsImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController()
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {

        if (registerRequest.getUsername()== null ||
                registerRequest.getEmail()== null ||
                registerRequest.getPassword() == null)
            return ResponseEntity.badRequest().body(new MessageResponse("Invalid data: fields cannot be null!"));

        if (userRepo.existsByUsernameIgnoreCase(registerRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepo.existsByEmailIgnoreCase(registerRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found.")));

        // Create new user's account
        User user = User.builder().username(registerRequest.getUsername()).email(registerRequest.getEmail())
                .password(encoder.encode(registerRequest.getPassword())).roles(roles).build();
        // Save the user
        userRepo.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
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
                .username(userDetails.getUsername())
                .roles(roles)
                .build());
    }

}
