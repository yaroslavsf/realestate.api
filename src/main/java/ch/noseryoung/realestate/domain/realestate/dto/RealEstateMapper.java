package ch.noseryoung.realestate.domain.realestate.dto;

import ch.noseryoung.realestate.domain.realestate.RealEstate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RealEstateMapper {
    RealEstate fromDTO(RealEstateDTO dto);
    RealEstate fromRegisterDTO(RealEstateDTO realEstate);
    RealEstateDTO.RetrieveFullyDressed toRetrieveFullyDressedDTO(RealEstate realEstate);
    RealEstateDTO toDTO(RealEstate realEstate);
}
