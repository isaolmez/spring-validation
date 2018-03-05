package com.isa.spring.validation.basic.validation.jsr303;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<ValidEnum, String> {

    private Class<? extends Enum> targetEnum;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        this.targetEnum = constraintAnnotation.target();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Enum[] enumConstants = targetEnum.getEnumConstants();
        List<Enum> values = Arrays.stream(enumConstants).collect(Collectors.toList());
        return values.contains(value);
    }
}
