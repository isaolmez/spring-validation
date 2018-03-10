package com.isa.spring.validation.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractControllerTest {

    @Autowired
    protected ObjectMapper objectMapper;

    @Before
    public void baseSetUp() {

    }
}
