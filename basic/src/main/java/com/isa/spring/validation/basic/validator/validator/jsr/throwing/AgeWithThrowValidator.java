package com.isa.spring.validation.basic.validator.validator.jsr.throwing;

import com.isa.spring.validation.basic.validator.exception.InvalidInputException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeWithThrowValidator implements ConstraintValidator<AgeWithThrow, Integer> {

    private String code;

    @Override
    public void initialize(AgeWithThrow constraintAnnotation) {
        code = constraintAnnotation.code();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value < 0 || value > 100) {
            throw new InvalidInputException(code, "Invalid age");
        }

        return true;
    }
}
