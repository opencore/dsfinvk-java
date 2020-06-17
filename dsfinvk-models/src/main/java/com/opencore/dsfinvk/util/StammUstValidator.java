package com.opencore.dsfinvk.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.opencore.dsfinvk.models.stammdaten.StammUst;

public class StammUstValidator implements ConstraintValidator<ValidStammUst, StammUst> {

  private static final Map<Long, BigDecimal> UST_SAETZE = new HashMap<>();

  @Override
  public boolean isValid(StammUst obj, ConstraintValidatorContext context) {
    if (!UST_SAETZE.containsKey(obj.getUstSchluessel())) {
      return true;
    }

    return UST_SAETZE.get(obj.getUstSchluessel()).compareTo(obj.getUstSatz()) == 0;
  }

  static {
    UST_SAETZE.put(1L, new BigDecimal("19.00"));
    UST_SAETZE.put(2L, new BigDecimal("7.00"));
    UST_SAETZE.put(3L, new BigDecimal("10.70"));
    UST_SAETZE.put(4L, new BigDecimal("5.50"));
    UST_SAETZE.put(5L, new BigDecimal("0.00"));
    UST_SAETZE.put(6L, new BigDecimal("0.00"));
    UST_SAETZE.put(7L, new BigDecimal("0.00"));
  }

}
