package br.com.vanguardasistemas.adapter.rest.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankAndSizeValidator implements ConstraintValidator<NotBlankAndSize, String> {

  private int min;
  private int max;
  private String fieldName;

  @Override
  public void initialize(NotBlankAndSize constraintAnnotation) {
    this.min = constraintAnnotation.min();
    this.max = constraintAnnotation.max();
    this.fieldName = constraintAnnotation.fieldName();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null || value.trim().isEmpty()) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
        "'" + fieldName + "' cannot be empty"
      ).addConstraintViolation();
      return false;
    }

    if (value.length() < min) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
        "'" + fieldName + "' must have a minimum of " + min + " characters"
      ).addConstraintViolation();
      return false;
    }

    if (value.length() > max) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
        "'" + fieldName + "' must have a maximum of " + max + " characters"
      ).addConstraintViolation();
      return false;
    }

    return true;
  }
} 