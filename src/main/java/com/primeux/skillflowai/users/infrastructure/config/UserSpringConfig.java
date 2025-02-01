package com.primeux.skillflowai.users.infrastructure.config;

import com.primeux.skillflowai.common.domain.UseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(basePackages = {"com.primeux.skillflowai.users"}, includeFilters = {@ComponentScan.Filter(type = ANNOTATION, classes = {UseCase.class})})
public class UserSpringConfig {

}
