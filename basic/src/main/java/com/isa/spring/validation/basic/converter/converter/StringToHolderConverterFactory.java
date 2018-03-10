package com.isa.spring.validation.basic.converter.converter;

import com.isa.spring.validation.basic.converter.model.Holder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

@Slf4j
public class StringToHolderConverterFactory implements ConverterFactory<String, Holder> {

    @Override
    public <T extends Holder> Converter<String, T> getConverter(Class<T> targetClass) {
        return new StringToHolderConverter<>(targetClass);
    }

    private static class StringToHolderConverter<T extends Holder> implements Converter<String, T> {

        private final Class<T> targetClass;

        public StringToHolderConverter(Class targetClass) {
            this.targetClass = targetClass;
        }

        @Override
        public T convert(String s) {
            T result = null;
            try {
                result = targetClass.newInstance();
                result.save(s);
            } catch (InstantiationException e) {
                log.error("Error occurred", e);
            } catch (IllegalAccessException e) {
                log.error("Error occurred", e);
            }

            return result;
        }
    }
}
