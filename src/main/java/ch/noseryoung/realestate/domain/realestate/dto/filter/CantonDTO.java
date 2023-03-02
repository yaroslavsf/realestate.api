package ch.noseryoung.realestate.domain.realestate.dto.filter;

import ch.noseryoung.realestate.core.validation.realestate.canton.Canton;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CantonDTO {
    @Canton
    private String canton;
}
