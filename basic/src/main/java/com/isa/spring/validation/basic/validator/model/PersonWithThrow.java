package com.isa.spring.validation.basic.validator.model;

import com.isa.spring.validation.basic.validator.validator.jsr.throwing.AgeWithThrow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonWithThrow {

    private String name;

    @AgeWithThrow(code = "InvalidInputCatchedFromThrowing")
    private int age;
}