package com.opencore.dsfinvk.util;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VatIdValidator implements ConstraintValidator<ValidVatId, String> {

  // Regex according to this list
  // https://www.bzst.de/SharedDocs/Downloads/DE/Merkblaetter/ust_idnr_aufbau.pdf?__blob=publicationFile&v=4
  private static final Pattern VAT_REGEX = Pattern.compile("(?xi)^(\n"
                                                           + "ATU[0-9]{8} |                              # Austria\n"
                                                           + "BE0[0-9]{9} |                              # Belgium\n"
                                                           // https://finanzen.belgium.be/de/unternehmen/mwst/erkl%C3%A4rung/beginn-%C3%A4nderung-und-einstellung-der-t%C3%A4tigkeit#q1
                                                           + "BG[0-9]{9,10} |                            # Bulgaria\n"
                                                           + "HR[0-9]{11} |                              # Croatia\n"
                                                           + "CY[0-9]{8}[A-Z] |                          # Cyprus\n"
                                                           + "CZ[0-9]{8,10} |                            # Czech Republic\n"
                                                           + "DE[0-9]{9} |                               # Germany\n"
                                                           + "DK[0-9]{8} |                               # Denmark\n"
                                                           + "EE[0-9]{9} |                               # Estonia\n"
                                                           + "EL[0-9]{9} |                               # Greece\n"
                                                           + "ES[AZ][0-9]{7}(?:[0-9]|[A-Z]) |            # Spain\n"
                                                           + "FI[0-9]{8} |                               # Finland\n"
                                                           + "FR[0-9A-Z]{2}[0-9]{9} |                    # France\n"
                                                           + "GB([0-9]{9}([0-9]{3})?|[A-Z]{2}[0-9]{3}) | # United Kingdom\n"
                                                           + "HU[0-9]{8} |                               # Hungary\n"
                                                           + "IE[0-9]{7}[A-Z]{1,2} |                     # Ireland\n"
                                                           + "IE[0-9][A-Z][0-9]{5}[A-Z] |                # Ireland (2)\n"
                                                           + "IT[0-9]{11} |                              # Italy\n"
                                                           + "LT([0-9]{9}|[0-9]{12}) |                   # Lithuania\n"
                                                           + "LU[0-9]{8} |                               # Luxembourg\n"
                                                           + "LV[0-9]{11} |                              # Latvia\n"
                                                           + "MT[0-9]{8} |                               # Malta\n"
                                                           + "NL[0-9]{9}B[0-9]{2} |                      # Netherlands\n"
                                                           + "PL[0-9]{10} |                              # Poland\n"
                                                           + "PT[0-9]{9} |                               # Portugal\n"
                                                           + "RO[0-9]{2,10} |                            # Romania\n"
                                                           + "SE[0-9]{12} |                              # Sweden\n"
                                                           + "SI[0-9]{8} |                               # Slovenia\n"
                                                           + "SK[0-9]{10}                                # Slovakia\n"
                                                           + ")$");

  @Override
  public boolean isValid(String obj, ConstraintValidatorContext context) {
    return obj == null || VAT_REGEX.matcher(obj.trim()).matches();
  }

}
