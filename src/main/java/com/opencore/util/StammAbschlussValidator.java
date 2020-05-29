package com.opencore.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.opencore.dsfinvk.stammdaten.StammAbschluss;

public class StammAbschlussValidator implements ConstraintValidator<ValidStammAbschluss, StammAbschluss> {

  @Override
  public boolean isValid(StammAbschluss value, ConstraintValidatorContext context) {
    if (value.getStnr() == null && value.getUstid() == null) {
      return false;
    }

    // TODO: The specs say "either ... or" but I've implemented "or". Needs clarification.
    return !value.getStnr().isBlank() || !value.getUstid().isBlank();
  }
}
