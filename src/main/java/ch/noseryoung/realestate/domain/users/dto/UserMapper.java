package ch.noseryoung.realestate.domain.users.dto;

import ch.noseryoung.realestate.domain.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User fromDTO(UserDTO dto);
    User fromRegisterDTO(UserDTO.Register user);
    UserDTO.RetrieveLightlyDressed toRetrieveLightlyDressedDTO(User user);
    UserDTO toDTO(User user);
}
