package com.isa.spring.validation.basic.converter.model;

public class UpperCaseHolder implements Holder {

    private String value;

    @Override
    public String get() {
        return value;
    }

    @Override
    public void save(String value) {
        this.value = value;
    }
}
