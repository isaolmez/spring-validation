package com.isa.spring.validation.basic.validator.controller;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.spring.validation.basic.AbstractControllerTest;
import com.isa.spring.validation.basic.validator.Application;
import com.isa.spring.validation.basic.validator.model.Person;
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
public class JsrValidationControllerTest extends AbstractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSucceed_ForCreate() throws Exception {
        Person person = Person.builder()
                .name("test")
                .age(10)
                .build();

        mockMvc.perform(post("/validator/jsr/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.age").value(10));
    }

    @Test
    public void shouldReturnBadRequest_ForCreate() throws Exception {
        Person person = Person.builder()
                .name("test")
                .age(-1)
                .build();

        mockMvc.perform(post("/validator/jsr/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(EMPTY));
    }

    @Test
    public void shouldSucceed_ForCreateWithMulti() throws Exception {
        Person person = Person.builder()
                .name("test")
                .age(10)
                .build();

        final String ageParam = "10";
        mockMvc.perform(post("/validator/jsr/createWithMulti")
                .param("age", ageParam)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.age").value(10));
    }

    @Test
    public void shouldReturnBadRequest_ForCreateWithMulti() throws Exception {
        Person person = Person.builder()
                .name("test")
                .age(10)
                .build();

        final String ageParam = "-1";
        mockMvc.perform(post("/validator/jsr/createWithMulti")
                .param("age", ageParam)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").isNotEmpty())
                .andExpect(jsonPath("$.message").isNotEmpty());
    }

    @Test
    public void shouldReturnBadRequest_ForCreateWithMulti2() throws Exception {
        Person person = Person.builder()
                .name("test")
                .age(-1)
                .build();

        final String ageParam = "10";
        mockMvc.perform(post("/validator/jsr/createWithMulti")
                .param("age", ageParam)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(EMPTY));
    }
}