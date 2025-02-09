package com.primeux.skillflowai.users.business.domain.services;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUserCommand {
    @NotBlank
    private String organizationName;
    private String firstName;
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
