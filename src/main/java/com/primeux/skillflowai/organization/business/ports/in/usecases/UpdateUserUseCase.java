package com.primeux.skillflowai.organization.business.ports.in.usecases;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public interface UpdateUserUseCase {

    void update(UpdateUserCommand command);

    record UpdateUserCommand(
            @NotBlank String id,
            @NotBlank String email,
            String firstName,
            String lastName,
            LocalDate birthday
    ) {
    }
}
