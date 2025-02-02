package com.primeux.skillflowai.users.presentation.resources;

import lombok.Data;

@Data
public class LoginResponseDto {

    private final String token;
    private final long expiresInMs;

}
