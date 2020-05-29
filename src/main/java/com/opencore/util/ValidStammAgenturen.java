package com.opencore.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = StammAgenturenValidator.class)
@Documented
public @interface ValidStammAgenturen {

  String message() default "Either STNR or USTID need to be provided";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
