package ch.noseryoung.realestate.domain.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService{
    private RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(UUID id) {
        Optional<Role> role =  roleRepository.findById(id);
        if (!role.isPresent()) throw new NoSuchElementException();
        Role r = role.get();
        return r;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(UUID id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role update(Role role) {
        Role r = this.findById(role.getId());
        r = role;
        return roleRepository.save(r);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
