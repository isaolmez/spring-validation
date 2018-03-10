package com.isa.spring.validation.basic.validator.controller;

import com.isa.spring.validation.basic.validator.model.Person;
import com.isa.spring.validation.basic.validator.model.PersonWithThrow;
import com.isa.spring.validation.basic.validator.validator.jsr.Age;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/validator/jsr")
public class JsrValidationController {

    // Handled by @ExceptionHandler(MethodArgumentNotValidException.class)in ResponseEntityExceptionHandler
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody @Valid Person person) {
        return person;
    }

    // @Age is handled by @ExceptionHandler(ConstraintViolationException.class)
    @PostMapping(path = "/createWithMulti", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person createWithMulti(@Valid @RequestBody Person person, @Age @RequestParam("age") int age) {
        return person;
    }

    // Handled by advice and @ExceptionHandler(InvalidInputException.class)
    @PostMapping(path = "/createWithBindingResult", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person createWithBindingResult(@RequestBody @Valid Person person, BindingResult bindingResult) {
        return person;
    }

    // Handled by @ExceptionHandler(InvalidInputException.class)
    @PostMapping(path = "/createThrow", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonWithThrow createWithThrowing(@RequestBody @Valid PersonWithThrow person) {
        return person;
    }
}
