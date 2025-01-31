package com.primeux.skillflowai.security.application.dto;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;
    private String password;
}
