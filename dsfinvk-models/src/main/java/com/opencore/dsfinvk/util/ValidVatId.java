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
 * This does _not_ validate any checksums.
 * It only checks for syntactical correctness.
 */
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = VatIdValidator.class)
@Documented
public @interface ValidVatId {

  String message() default "Not a valid VAT ID";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
