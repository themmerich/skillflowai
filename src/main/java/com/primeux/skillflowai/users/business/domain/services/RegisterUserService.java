package com.primeux.skillflowai.users.business.domain.services;

import com.primeux.skillflowai.app.tenant.TenantContext;
import com.primeux.skillflowai.shared.annotation.UseCase;
import com.primeux.skillflowai.shared.exception.ValidationFailedException;
import com.primeux.skillflowai.users.business.domain.model.*;
import com.primeux.skillflowai.users.business.ports.repositories.OrganizationRepository;
import com.primeux.skillflowai.users.business.ports.repositories.UserRepository;
import com.primeux.skillflowai.users.business.ports.services.PasswordEncoding;
import com.primeux.skillflowai.users.business.ports.usecases.RegisterUser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class RegisterUserService implements RegisterUser {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final PasswordEncoding passwordEncoding;


    public User register(RegisterUserCommand registerUserCommand) {
        Email email = Email.of(registerUserCommand.getEmail());
        if (userRepository.existsByEmail(email)) {
            throw new ValidationFailedException(String.format("User with email %s already exists", registerUserCommand.getEmail()));
        }
        //TODO: Check dass Organization nur einmal vorhanden ist. Nach erfolgreichem Erstellen ein Event werfen

        Organization organization = new Organization();
        organization.setId(OrganizationId.fromString(TenantContext.getCurrentTenant()));
        organization.setName(registerUserCommand.getOrganizationName());
        organizationRepository.save(organization);

        Password password = Password.of(passwordEncoding.encode(registerUserCommand.getPassword()));
        User newUser = User.create(
                registerUserCommand.getFirstName(),
                registerUserCommand.getLastName(),
                email,
                password,
                Role.createTestRole("USER_READ"));

        //TODO: Confirmation-Email an User schicken, Login erst dann möglich
        return userRepository.save(newUser);
    }
}
