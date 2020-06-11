package com.opencore.dsfinvk.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation to validate the ISO 3166 ALPHA 3 country code.
 */
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = Iso3166Alpha3CountryValidator.class)
@Documented
public @interface ValidIso3166Alpha3Country {

  String message() default "Not an ISO-3166 ALPHA 3 Country Code";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
