package com.isa.spring.validation.basic.converter.controller;

import com.isa.spring.validation.basic.converter.model.Job;
import com.isa.spring.validation.basic.converter.model.NoOpHolder;
import com.isa.spring.validation.basic.converter.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/converter")
public class ConverterController {

    private final ConversionService conversionService;

    @Autowired
    private ApplicationContext context;

    @Autowired
    public ConverterController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping(path = "/basic",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Job basic(@RequestBody Profession profession) {
        return conversionService.convert(profession, Job.class);
    }

    @PostMapping(path = "/factory", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoOpHolder factory(@RequestParam("value") String value) {
        NoOpHolder holder = conversionService.convert(value, NoOpHolder.class);
        return holder;
    }
}
