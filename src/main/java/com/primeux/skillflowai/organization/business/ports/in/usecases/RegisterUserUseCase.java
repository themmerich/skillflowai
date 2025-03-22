package com.primeux.skillflowai.organization.business.ports.in.usecases;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public interface RegisterUserUseCase {

    boolean register(@Valid RegisterUserCommand command);

    record RegisterUserCommand(
            @NotBlank String organizationName,
            @NotBlank String email,
            @NotBlank String password,
            String firstName,
            String lastName
    ) {
    }
}
