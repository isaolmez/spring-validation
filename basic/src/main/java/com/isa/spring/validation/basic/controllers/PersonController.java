package com.isa.spring.validation.basic.controllers;

import com.isa.spring.validation.basic.model.Person;
import com.isa.spring.validation.basic.validation.PersonValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class PersonController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new PersonValidator());
    }

    @PostMapping("/person")
    public void get(@ModelAttribute Person person, BindingResult bindingResult) {
    }
}
