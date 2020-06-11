package com.opencore.dsfinvk.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.opencore.dsfinvk.models.stammdaten.StammAgenturen;

// TODO: Kann auch validieren, dass alle Felder leer sind wenn AGENTUR_ID == 0
public class StammAgenturenValidator implements ConstraintValidator<ValidStammAgenturen, StammAgenturen> {

  @Override
  public boolean isValid(StammAgenturen value, ConstraintValidatorContext context) {
    if (value.getAgenturStnr() == null && value.getAgenturUstid() == null) {
      return false;
    }

    // TODO: The specs say "either ... or" but I've implemented "or". Needs clarification.
    return !value.getAgenturStnr().isBlank() || !value.getAgenturUstid().isBlank();
  }

}
