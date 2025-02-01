package com.primeux.skillflowai.users.domain.registration;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
