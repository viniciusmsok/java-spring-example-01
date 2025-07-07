package br.com.vanguardasistemas.adapter.rest.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.UUID;

public class RequiredUUIDValidator implements ConstraintValidator<RequiredUUID, UUID> {
    private String attributeName;

    @Override
    public void initialize(RequiredUUID constraintAnnotation) {
        this.attributeName = constraintAnnotation.attributeName();
    }

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext context) {
        if (value == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                "'" + attributeName + "' cannot be null"
            ).addConstraintViolation();
            return false;
        }
        return true;
    }
} 