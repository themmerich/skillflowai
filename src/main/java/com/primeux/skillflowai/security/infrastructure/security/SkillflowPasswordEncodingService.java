package com.primeux.skillflowai.security.infrastructure.security;

import com.primeux.skillflowai.security.domain.service.PasswordEncodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SkillflowPasswordEncodingService implements PasswordEncodingService {
    private final PasswordEncoder passwordEncoder;

    public String encode(String unencodedPassword) {
        return passwordEncoder.encode(unencodedPassword);
    }

}
