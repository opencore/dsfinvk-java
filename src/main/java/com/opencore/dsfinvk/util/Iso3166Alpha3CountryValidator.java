package com.opencore.dsfinvk.util;

import java.util.Locale;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Iso3166Alpha3CountryValidator implements ConstraintValidator<ValidIso3166Alpha3Country, String> {

  private final Set<String> countries = Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA3);

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value == null || countries.contains(value.trim().toUpperCase());
  }
}
