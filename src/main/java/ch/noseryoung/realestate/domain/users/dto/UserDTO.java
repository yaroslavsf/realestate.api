package ch.noseryoung.realestate.domain.users.dto;


import ch.noseryoung.realestate.domain.role.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {
//    @Alphabetical
    private String name;
    private String surname;
    private String email;
    @Getter
    @Setter
    @Schema(name = "UserDTO.Register")
    public static class Register extends UserDTO {
        private String password;
    }

    @Getter
    @Setter
    @Schema(name = "UserDTO.RetrieveLightlyDressed")
    public static class RetrieveLightlyDressed extends UserDTO {
        protected UUID id;
        protected Role role;
    }


}
