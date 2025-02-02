package com.primeux.skillflowai.users.infrastructure.config;

import com.primeux.skillflowai.shared.annotation.UseCase;
import com.primeux.skillflowai.users.UserPermission;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(basePackageClasses = {UserPermission.class}, includeFilters = {@ComponentScan.Filter(type = ANNOTATION, classes = {UseCase.class})})
public class UserSpringConfig {

}
