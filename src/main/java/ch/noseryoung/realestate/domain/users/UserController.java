package ch.noseryoung.realestate.domain.users;

import ch.noseryoung.realestate.domain.realestate.RealEstate;
import ch.noseryoung.realestate.domain.realestate.dto.RealEstateDTO;
import ch.noseryoung.realestate.domain.role.Role;
import ch.noseryoung.realestate.domain.users.dto.UserDTO;
import ch.noseryoung.realestate.domain.users.dto.UserMapper;
import ch.noseryoung.realestate.domain.users.dto.filter.NameDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<UserDTO>> retrieveAll() {
        List<User> users = userService.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(user -> userDTOS.add(userMapper.toDTO(user)));
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<UserDTO.RetrieveLightlyDressed> retrieveById(@PathVariable(value="id") UUID id) {
        return new ResponseEntity<>(userMapper.toRetrieveLightlyDressedDTO(userService.findById(id)), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<UserDTO.RetrieveLightlyDressed> create(@Valid @RequestBody UserDTO.Register registerUser) {
        return new ResponseEntity<>(userMapper.toRetrieveLightlyDressedDTO(userService.register(userMapper.fromRegisterDTO(registerUser))), HttpStatus.CREATED);
    }

    @PostMapping("/search/by/name")
    public ResponseEntity<List<UserDTO>> searchByName(@RequestBody NameDTO nameDTO) {
        List<User> foundUsers = userService.searchByName(nameDTO.getName());
        List<UserDTO> resultToReturn = new ArrayList<>();
        foundUsers.forEach(user -> resultToReturn.add(userMapper.toDTO(user)));
        return new ResponseEntity<>(resultToReturn, HttpStatus.FOUND);
    }
}
