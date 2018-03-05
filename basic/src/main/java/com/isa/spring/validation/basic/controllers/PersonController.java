package com.isa.spring.validation.basic.controllers;

import com.isa.spring.validation.basic.model.Person;
import com.isa.spring.validation.basic.validation.spring.PersonValidator;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @InitBinder
    public void initBinder(ServletRequestDataBinder webDataBinder) {
        webDataBinder.addValidators(new PersonValidator());
    }

    @PostMapping("/create")
    public Person create(@Valid @RequestBody Person person, BindingResult bindingResult) {
        return person;
    }

    @PostMapping("/createWithPost")
    public Person createWithForm(@Valid @ModelAttribute Person person, BindingResult bindingResult) {
        return person;
    }
}
