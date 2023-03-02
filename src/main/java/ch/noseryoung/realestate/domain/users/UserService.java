package ch.noseryoung.realestate.domain.users;

import ch.noseryoung.realestate.domain.users.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> findAll();

    User register(User registerUser);

    User findById(UUID id);

    boolean userIsAgent(UUID userId);

    List<User> searchByName(String nameCriteria);
}
