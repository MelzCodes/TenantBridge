package com.tenantbridge.api.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ObjectsValidatorMethodValidator.class)
public @interface ValidateParameters {
    String message() default "Method parameters are not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
