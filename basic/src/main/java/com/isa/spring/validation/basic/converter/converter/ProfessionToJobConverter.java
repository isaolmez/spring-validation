package com.isa.spring.validation.basic.converter.converter;

import com.isa.spring.validation.basic.converter.model.Job;
import com.isa.spring.validation.basic.converter.model.Profession;
import java.util.Arrays;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class ProfessionToJobConverter implements Converter<Profession, Job> {

    @Override
    public Job convert(Profession profession) {
        Optional<Job> match = Arrays.stream(Job.values())
                .filter(job -> StringUtils.equals(job.name(), profession.name()))
                .findFirst();
        return match.orElse(Job.OTHER);
    }
}
