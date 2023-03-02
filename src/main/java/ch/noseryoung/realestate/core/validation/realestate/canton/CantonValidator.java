package ch.noseryoung.realestate.core.validation.realestate.canton;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CantonValidator implements ConstraintValidator<Canton, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        return value.matches("[a-zA-Z-]*");
    }
}
