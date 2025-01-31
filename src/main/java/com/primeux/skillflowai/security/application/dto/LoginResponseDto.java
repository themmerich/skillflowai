package com.primeux.skillflowai.security.application.dto;

import lombok.Data;

@Data
public class LoginResponseDto {

    private final String token;
    private final long expiresInMs;

}
