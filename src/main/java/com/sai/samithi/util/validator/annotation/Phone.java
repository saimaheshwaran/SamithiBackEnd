package com.sai.samithi.util.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sai.samithi.util.validator.PhoneValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target( { METHOD, FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
	 String message() default "{Phone}";
     
	 Class<?>[] groups() default {};
	     
	   Class<? extends Payload>[] payload() default {};
}
