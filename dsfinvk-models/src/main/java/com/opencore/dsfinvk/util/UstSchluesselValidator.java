package com.opencore.dsfinvk.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UstSchluesselValidator implements ConstraintValidator<ValidUstSchluessel, Long> {

  @Override
  public boolean isValid(Long obj, ConstraintValidatorContext context) {
    if (obj == null) {
      return false;
    }

    if (obj >= 1 && obj <= 7) {
      return true;
    }

    if (obj >= 11 && obj <= 12) {
      return true;
    }

    if (obj >= 21 && obj <= 22) {
      return true;
    }

    if (obj >= 1000) {
      return true;
    }

    return false;
  }

}
