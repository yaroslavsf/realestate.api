package ch.noseryoung.realestate.domain.users;

import ch.noseryoung.realestate.domain.users.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User register(User registerUser);
}
