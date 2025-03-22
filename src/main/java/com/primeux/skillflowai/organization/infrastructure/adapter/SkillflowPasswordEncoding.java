package com.primeux.skillflowai.organization.infrastructure.adapter;

import com.primeux.skillflowai.shared.security.PasswordEncoding;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SkillflowPasswordEncoding implements PasswordEncoding {
    private final PasswordEncoder passwordEncoder;

    public String encode(String unencodedPassword) {
        return passwordEncoder.encode(unencodedPassword);
    }

}
