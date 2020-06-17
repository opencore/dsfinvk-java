package com.opencore.dsfinvk.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = StammUstValidator.class)
@Documented
public @interface ValidStammUst {

  String message() default "UST_SATZ not valid for UST_SCHLUESSEL";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
