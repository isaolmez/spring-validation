package com.isa.spring.validation.basic.validator.controller;

import com.isa.spring.validation.basic.validator.model.Person;
import com.isa.spring.validation.basic.validator.validator.spring.PersonValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/validator/spring")
public class SpringValidationController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new PersonValidator());
    }

    @PostMapping("/create")
    public void create(@ModelAttribute Person person, BindingResult bindingResult) {
    }
}
