package com.isa.spring.validation.basic.validator.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvalidInputException extends RuntimeException {

    private String code;
    private String message;
}
