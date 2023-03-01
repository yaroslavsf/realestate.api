package ch.noseryoung.realestate.domain.users;

import ch.noseryoung.realestate.domain.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User register(User registerUser) {
        try {

            if (this.checkEmailForAgentPattern(registerUser.getEmail(), "@noseryoung.com")) {
                registerUser.setRole(roleRepository.findByName("Agent"));
            } else {
                registerUser.setRole(roleRepository.findByName("Client"));
            }

        } catch (Exception e) {
            System.out.println("role not found");
        }
        return userRepository.save(registerUser);
    }

    private boolean checkEmailForAgentPattern(String email, String pattern) {
        Pattern p = Pattern.compile(pattern + "$");
        Matcher matcher = p.matcher(email);

        return matcher.find();
    }
}
