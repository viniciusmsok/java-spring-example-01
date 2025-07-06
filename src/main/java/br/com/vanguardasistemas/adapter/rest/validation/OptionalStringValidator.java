package br.com.vanguardasistemas.adapter.rest.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OptionalStringValidator implements ConstraintValidator<OptionalString, String> {

  private int max;
  private String attributeName;
  private boolean onlyNumbers;

  @Override
  public void initialize(OptionalString constraintAnnotation) {
    this.max = constraintAnnotation.max();
    this.attributeName = constraintAnnotation.attributeName();
    this.onlyNumbers = constraintAnnotation.onlyNumbers();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    if (value.trim().isEmpty()) {
      return true;
    }
    if (onlyNumbers && !value.matches("^[0-9]+$")) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
        "'" + attributeName + "' must contain only numbers"
      ).addConstraintViolation();
      return false;
    }
    if (value.length() > max) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
        "'" + attributeName + "' must have a maximum of " + max + " characters"
      ).addConstraintViolation();
      return false;
    }
    return true;
  }
} 