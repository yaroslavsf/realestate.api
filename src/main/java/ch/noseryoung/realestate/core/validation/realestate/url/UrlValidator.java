package ch.noseryoung.realestate.core.validation.realestate.url;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UrlValidator implements ConstraintValidator<Url, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        return value.matches("^.*homegate\\.ch.*");
    }
}
