package ch.noseryoung.realestate.domain.role.dto;


import ch.noseryoung.realestate.core.validation.user.email.Email;
import ch.noseryoung.realestate.domain.role.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleDTO {
    private String name;

}
