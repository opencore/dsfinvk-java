package com.opencore.dsfinvk.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UstSchluesselValidator implements ConstraintValidator<ValidUstSchluessel, Long> {

  public boolean isValid(Long obj, ConstraintValidatorContext context) {
    if (obj == null) {
      return false;
    }

    if (obj >= 1 && obj <= 7) {
      return true;
    }

    if (obj >= 1000) {
      return true;
    }

    return false;
  }

}
