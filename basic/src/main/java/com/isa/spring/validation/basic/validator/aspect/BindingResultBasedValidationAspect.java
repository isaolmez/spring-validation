package com.isa.spring.validation.basic.validator.aspect;

import com.isa.spring.validation.basic.validator.exception.InvalidInputException;
import java.util.List;
import java.util.stream.Collectors;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Aspect
@Component
public class BindingResultBasedValidationAspect {

    @Before("execution (* com.isa..controllers..*(..))")
    public void validateBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    List<FieldError> allErrors = result.getFieldErrors();
                    String message = allErrors.stream()
                            .map(DefaultMessageSourceResolvable::getDefaultMessage)
                            .collect(Collectors.joining(","));
                    throw new InvalidInputException("InvalidInput", message);
                }
            }
        }
    }
}
