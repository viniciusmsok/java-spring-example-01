package br.com.vanguardasistemas.adapter.rest.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredStringValidator implements ConstraintValidator<RequiredString, String> {

  private int min;
  private int max;
  private String attributeName;
  private boolean onlyNumbers;

  @Override
  public void initialize(RequiredString constraintAnnotation) {
    this.min = constraintAnnotation.min();
    this.max = constraintAnnotation.max();
    this.attributeName = constraintAnnotation.attributeName();
    this.onlyNumbers = constraintAnnotation.onlyNumbers();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null || value.trim().isEmpty()) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
        "'" + attributeName + "' cannot be empty"
      ).addConstraintViolation();
      return false;
    }

    if (onlyNumbers && !value.matches("^[0-9]+$")) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
        "'" + attributeName + "' must contain only numbers"
      ).addConstraintViolation();
      return false;
    }

    if (value.length() < min) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
        "'" + attributeName + "' must have a minimum of " + min + " characters"
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