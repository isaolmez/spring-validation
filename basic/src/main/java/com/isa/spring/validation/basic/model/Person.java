package com.isa.spring.validation.basic.model;

import com.isa.spring.validation.basic.validation.jsr303.ValidEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;

    private int age;

    @ValidEnum(target = Gender.class)
    private String gender;
}