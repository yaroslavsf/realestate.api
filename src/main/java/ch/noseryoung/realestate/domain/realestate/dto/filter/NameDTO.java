package ch.noseryoung.realestate.domain.realestate.dto.filter;

import ch.noseryoung.realestate.core.validation.realestate.name.Name;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameDTO {
    @Name
    private String name;
}
