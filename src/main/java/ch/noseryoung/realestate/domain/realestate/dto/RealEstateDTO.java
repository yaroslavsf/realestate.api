package ch.noseryoung.realestate.domain.realestate.dto;


import ch.noseryoung.realestate.core.validation.realestate.canton.Canton;
import ch.noseryoung.realestate.core.validation.realestate.name.Name;
import ch.noseryoung.realestate.core.validation.realestate.price.Price;
import ch.noseryoung.realestate.core.validation.realestate.square.Square;
import ch.noseryoung.realestate.core.validation.realestate.url.Url;
import ch.noseryoung.realestate.domain.realestate.RealEstate;
import ch.noseryoung.realestate.domain.role.Role;
import ch.noseryoung.realestate.domain.userrealestate.UserRealEstate;
import ch.noseryoung.realestate.domain.userrealestate.dto.UserRealEstateDTO;
import ch.noseryoung.realestate.domain.users.User;
import ch.noseryoung.realestate.domain.users.dto.UserDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class RealEstateDTO {

    @Name
    private String name;
    @Square
    private String square;
    @Canton
    private String canton;
    @Url
    private String url;
    @Price
    private BigDecimal price;

//    @Getter
//    @Setter
//    @Schema(name = "RealEstateDTO.Create")
//    public static class Create extends RealEstateDTO {
//        protected User user;
//    }

    @Getter
    @Setter
    @Schema(name = "RealEstateDTO.RetrieveFullyDressed")
    public static class RetrieveFullyDressed extends RealEstateDTO {

        protected UserDTO user;
        protected List<UserRealEstateDTO.RetrieveForRealEstate> userRealEstates;

    }


}
