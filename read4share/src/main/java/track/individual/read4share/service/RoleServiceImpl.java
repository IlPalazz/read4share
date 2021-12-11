package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import track.individual.read4share.exception.auth.RoleNotFoundException;
import track.individual.read4share.model.ERole;
import track.individual.read4share.model.Role;
import track.individual.read4share.repository.RoleRepo;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    @Override
    public Role findByName(ERole roleName) {
        Optional<Role> role = roleRepo.findByName(roleName);
        if (role.isEmpty()) {
            log.error("Error: Role " + roleName.name() + " not found!");
            throw new RoleNotFoundException("Error: Role " + roleName.name() + " not found!");
        }
        return role.get();
    }
}
