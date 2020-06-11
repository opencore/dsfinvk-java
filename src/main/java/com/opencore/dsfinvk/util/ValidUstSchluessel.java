package com.opencore.dsfinvk.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = UstSchluesselValidator.class)
@Documented
public @interface ValidUstSchluessel {

  String message() default "Not a valid UST Schlüssel (must be 1-7 or 1000 or higher)";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
