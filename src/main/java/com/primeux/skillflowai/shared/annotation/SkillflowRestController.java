package com.primeux.skillflowai.shared.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RestController
@RequestMapping
@PreAuthorize("denyAll()")
public @interface SkillflowRestController {
    @AliasFor(
            annotation = RequestMapping.class,
            attribute = "value"
    )
    String[] value() default {};
}
