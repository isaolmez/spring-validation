package com.isa.spring.validation.basic.converter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.isa.spring.validation.basic.AbstractControllerTest;
import com.isa.spring.validation.basic.converter.Application;
import com.isa.spring.validation.basic.converter.model.Profession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ConverterControllerTest extends AbstractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldConvert() throws Exception {
        mockMvc.perform(post("/converter/basic")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Profession.ENGINEER)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldConvertWithFactory() throws Exception {
        mockMvc.perform(post("/converter/factory")
                .param("value", "john doe"))
                .andExpect(status().isOk());
    }
}