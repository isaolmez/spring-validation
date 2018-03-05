package com.isa.spring.validation.basic.validation.jsr303;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = EnumValidator.class)
public @interface ValidEnum {

    String message() default
            "{org.hibernate.validator.referenceguide.chapter06.CheckCase.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends Enum> target();
}
