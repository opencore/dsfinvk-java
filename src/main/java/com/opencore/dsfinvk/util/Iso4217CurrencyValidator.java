package com.opencore.dsfinvk.util;

import java.util.Currency;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Iso4217CurrencyValidator implements ConstraintValidator<ValidIso4217Currency, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    try {
      Currency.getInstance(value.trim().toUpperCase());
      return true;
    } catch (IllegalArgumentException ignored) {
      return false;
    }
  }
}
