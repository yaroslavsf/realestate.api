package ch.noseryoung.realestate.core.validation.realestate.price;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PriceValidator implements ConstraintValidator<Price, BigDecimal> {
    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        if (value.compareTo(new BigDecimal(500)) == -1 || value.compareTo(new BigDecimal(4500)) == 1) return false;
        return true;
    }
}
