package ch.noseryoung.realestate.domain.userrealestate.dto;


import ch.noseryoung.realestate.core.validation.user.email.Email;
import ch.noseryoung.realestate.domain.enums.RealEstateStatus;
import ch.noseryoung.realestate.domain.realestate.RealEstate;
import ch.noseryoung.realestate.domain.realestate.dto.RealEstateDTO;
import ch.noseryoung.realestate.domain.role.Role;
import ch.noseryoung.realestate.domain.users.User;
import ch.noseryoung.realestate.domain.users.dto.UserDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserRealEstateDTO {


    private UUID id;
    private RealEstateStatus status = RealEstateStatus.PENDING;

    //
    @Getter
    @Setter
    @Schema(name = "UserDTO.Create")
    public static class Create extends UserRealEstateDTO {
        private UserDTO user;
        private RealEstateDTO realEstate;
    }

    @Getter
    @Setter
    @Schema(name = "UserDTO.RetrieveForUser")
    public static class RetrieveForUser extends UserRealEstateDTO {
        private RealEstateDTO realEstate;
    }
    @Getter
    @Setter
    @Schema(name = "UserDTO.RetrieveForRealEstate")
    public static class RetrieveForRealEstate extends UserRealEstateDTO {
        private UserDTO user;
    }



}
