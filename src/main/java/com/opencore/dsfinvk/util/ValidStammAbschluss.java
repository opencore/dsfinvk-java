package com.opencore.dsfinvk.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation to validate that either USTID or STNR was set
 */
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = StammAbschlussValidator.class)
@Documented
public @interface ValidStammAbschluss {

  String message() default "Either STNR or USTID need to be provided";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
