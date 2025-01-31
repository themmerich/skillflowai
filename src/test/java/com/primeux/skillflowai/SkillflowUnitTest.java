package com.primeux.skillflowai;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

public class SkillflowUnitTest {

    @Test
    void test() {
        System.out.println(UUID.randomUUID());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("Password: " + passwordEncoder.encode("123"));
    }

}
