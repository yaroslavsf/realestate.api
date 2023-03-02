package ch.noseryoung.realestate.domain.role;

import ch.noseryoung.realestate.domain.role.dto.RoleDTO;
import ch.noseryoung.realestate.domain.role.dto.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;
    private RoleMapper roleMapper;

    @Autowired
    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Role>> retrieveAll() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/by/{role_id}")
    public ResponseEntity<Role> retrieveById(@PathVariable(value="role_id") UUID id) {
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Role> create(@RequestBody RoleDTO role) {
        return new ResponseEntity<>(roleService.save(roleMapper.fromDTO(role)), HttpStatus.CREATED);
    }
    @DeleteMapping("/{role_id}")
    public ResponseEntity<Void> delete(@PathVariable(value="role_id") UUID id){
        roleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
