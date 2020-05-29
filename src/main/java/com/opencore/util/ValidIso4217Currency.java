package com.opencore.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation to validate the ISO 4217 currency codes.
 */
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = Iso4217CurrencyValidator.class)
@Documented
public @interface ValidIso4217Currency {

  String message() default "Not an ISO-4217 Currency Code";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
