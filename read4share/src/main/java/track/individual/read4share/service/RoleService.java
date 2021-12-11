package track.individual.read4share.service;

import track.individual.read4share.model.ERole;
import track.individual.read4share.model.Role;

public interface RoleService {
    Role findByName(ERole roleName);
}
