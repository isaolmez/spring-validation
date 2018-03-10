package com.isa.spring.validation.basic.validator.validator.jsr.throwing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = AgeWithThrowValidator.class)
public @interface AgeWithThrow {

    String message() default "{javax.validation.constraints.NotNull.message}";

    String code() default "InvalidInput";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
