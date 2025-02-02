package com.primeux.skillflowai.users.core.domain.services;

import lombok.Data;

@Data
public class RegisterUserCommand {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
