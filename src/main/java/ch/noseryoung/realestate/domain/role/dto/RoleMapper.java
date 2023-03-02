package ch.noseryoung.realestate.domain.role.dto;

import ch.noseryoung.realestate.domain.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    Role fromDTO(RoleDTO roleDTO);
}
