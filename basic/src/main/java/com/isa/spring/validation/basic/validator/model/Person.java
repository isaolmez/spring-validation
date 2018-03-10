package com.isa.spring.validation.basic.validator.model;

import com.isa.spring.validation.basic.validator.validator.jsr.Age;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String name;

    @Age(code = "InvalidInput")
    private int age;
}