package com.opencore.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.opencore.dsfinvk.stammdaten.StammAbschluss;

public class TaxInformationValidator implements ConstraintValidator<ValidTaxInformation, StammAbschluss> {

  @Override
  public boolean isValid(StammAbschluss obj, ConstraintValidatorContext context) {
    if (obj.getStnr() == null && obj.getUstid() == null) {
      return false;
    }

    // TODO: The specs say "either ... or" but I've implemented "or". Needs clarification.
    return !obj.getStnr().isBlank() || !obj.getUstid().isBlank();
  }

}
