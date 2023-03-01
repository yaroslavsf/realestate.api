package ch.noseryoung.realestate.core.validation.realestate.square;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = SquareValidator.class)
public @interface Square {
    String message() default "The given Text doesnt match the pattern";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}