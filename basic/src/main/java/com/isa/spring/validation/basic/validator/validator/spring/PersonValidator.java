package com.isa.spring.validation.basic.validator.validator.spring;

import com.isa.spring.validation.basic.validator.model.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    public boolean supports(Class clazz) {
        return Person.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Person p = (Person) obj;
        if (p.getAge() < 0) {
            e.rejectValue("age", "age.negative");
        } else if (p.getAge() > 110) {
            e.rejectValue("age", "age.large");
        }
    }
}