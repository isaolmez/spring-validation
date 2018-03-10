package com.isa.spring.validation.basic.validator.exception;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.metadata.ConstraintDescriptor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();

        ErrorCode errorCode = new ErrorCode();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            ConstraintDescriptor<?> constraintDescriptor = constraintViolation.getConstraintDescriptor();
            String code = (String) constraintDescriptor.getAttributes().getOrDefault("code", "InvalidInput");
            String message = constraintViolation.getMessage();
            errorCode = new ErrorCode(code, message);
        }

        return ResponseEntity.badRequest().body(errorCode);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handleInvalidInputException(InvalidInputException exception) {
        ErrorCode errorCode = new ErrorCode(exception.getCode(), exception.getMessage());
        return ResponseEntity.badRequest().body(errorCode);
    }
}
