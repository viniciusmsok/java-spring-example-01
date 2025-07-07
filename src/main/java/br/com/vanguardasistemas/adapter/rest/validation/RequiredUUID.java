package br.com.vanguardasistemas.adapter.rest.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RequiredUUIDValidator.class)
public @interface RequiredUUID {
    String message() default "UUID is required and must be valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String attributeName();
} 