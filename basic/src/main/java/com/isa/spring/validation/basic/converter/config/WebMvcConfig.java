package com.isa.spring.validation.basic.converter.config;

import com.isa.spring.validation.basic.converter.converter.ProfessionToJobConverter;
import com.isa.spring.validation.basic.converter.converter.StringToHolderConverterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ProfessionToJobConverter());
        registry.addConverterFactory(new StringToHolderConverterFactory());
    }
}
