package com.isa.spring.validation.basic.validator.validator.jsr;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    @Override
    public void initialize(Age constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value < 0 || value > 100) {
            return false;
        }

        return true;
    }
}
