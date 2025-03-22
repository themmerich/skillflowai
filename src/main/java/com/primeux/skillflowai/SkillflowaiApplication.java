package com.primeux.skillflowai;

import com.primeux.skillflowai.shared.annotation.UseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@SpringBootApplication
@Configuration
@ComponentScan(includeFilters = {@ComponentScan.Filter(type = ANNOTATION, classes = {UseCase.class})})
public class SkillflowaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillflowaiApplication.class, args);
    }
}
