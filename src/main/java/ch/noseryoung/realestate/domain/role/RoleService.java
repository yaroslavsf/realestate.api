package ch.noseryoung.realestate.domain.role;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    List<Role> findAll();

    Role findById(UUID id);

    Role save(Role role);

    void deleteById(UUID id);

    Role update(Role role);
    Role findByName(String name);
}
