package com.primeux.skillflowai.users.business.ports.usecases;

import com.primeux.skillflowai.users.business.domain.model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public interface RegisterUserUseCase {

    User register(@Valid RegisterUserCommand command);

    record RegisterUserCommand(
            @NotBlank String organizationName,
            @NotBlank String email,
            @NotBlank String password,
            String firstName,
            String lastName
    ) {
    }
}
