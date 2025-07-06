package br.com.vanguardasistemas.adapter.rest.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OptionalStringValidator.class)
public @interface OptionalString {
  String message() default "";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
  int max() default Integer.MAX_VALUE;
  String attributeName();
  boolean onlyNumbers() default false;
} 