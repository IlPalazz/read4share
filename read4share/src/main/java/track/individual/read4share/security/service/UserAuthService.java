package track.individual.read4share.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import track.individual.read4share.dto.response.JwtResponse;

public interface UserAuthService extends UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    //JwtResponse loginUser(String username, String password);


}
