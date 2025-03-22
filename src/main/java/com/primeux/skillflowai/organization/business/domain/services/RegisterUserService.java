package com.primeux.skillflowai.organization.business.domain.services;

import com.primeux.skillflowai.organization.business.domain.model.*;
import com.primeux.skillflowai.organization.business.ports.in.usecases.RegisterUserUseCase;
import com.primeux.skillflowai.organization.business.ports.out.repositories.OrganizationRepository;
import com.primeux.skillflowai.organization.business.ports.out.repositories.UserRepository;
import com.primeux.skillflowai.shared.annotation.UseCase;
import com.primeux.skillflowai.shared.security.PasswordEncoding;
import com.primeux.skillflowai.shared.security.Roles;
import com.primeux.skillflowai.shared.tenant.TenantContext;
import com.primeux.skillflowai.shared.validation.ValidationFailedException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
class RegisterUserService implements RegisterUserUseCase {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final PasswordEncoding passwordEncoding;


    public boolean register(RegisterUserCommand registerUserCommand) {
        Email email = Email.fromString(registerUserCommand.email());
        if (userRepository.existsByEmail(email)) {
            throw new ValidationFailedException(String.format("User with email %s already exists", registerUserCommand.email()));
        }
        //TODO: Check dass Organization nur einmal vorhanden ist. Nach erfolgreichem Erstellen ein Event werfen

        Organization organization = new Organization();
        organization.setId(OrganizationId.fromString(TenantContext.getCurrentTenant()));
        organization.setName(registerUserCommand.organizationName());
        organizationRepository.save(organization);

        Password password = Password.fromString(passwordEncoding.encode(registerUserCommand.password()));
        User newUser = User.create(
                registerUserCommand.firstName(),
                registerUserCommand.lastName(),
                email,
                password,
                Roles.ADMIN);

        //TODO: Confirmation-Email an User schicken, Login erst dann möglich
        userRepository.save(newUser);
        return true;
    }
}
