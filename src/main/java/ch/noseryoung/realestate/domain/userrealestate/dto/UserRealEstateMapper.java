package ch.noseryoung.realestate.domain.userrealestate.dto;

import ch.noseryoung.realestate.domain.realestate.RealEstate;
import ch.noseryoung.realestate.domain.userrealestate.UserRealEstate;
import ch.noseryoung.realestate.domain.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRealEstateMapper {
    UserRealEstate fromDTO(UserRealEstateDTO dto);
//    User fromRegisterDTO(UserDTO.Register user);

    UserRealEstateDTO.Create toCreateDTO(UserRealEstate userRealEstate);
    UserRealEstateDTO.RetrieveForRealEstate toRetrieveForRealEstate(UserRealEstate userRealEstate);

    UserRealEstateDTO.RetrieveForUser toRetrieveForUser(UserRealEstate userRealEstate);
    UserRealEstateDTO toDTO(UserRealEstate userRealEstate);
}
