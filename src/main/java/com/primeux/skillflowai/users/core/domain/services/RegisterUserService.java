package com.primeux.skillflowai.users.core.domain.services;

import com.primeux.skillflowai.shared.annotation.UseCase;
import com.primeux.skillflowai.shared.exception.ValidationFailedException;
import com.primeux.skillflowai.users.core.domain.model.Email;
import com.primeux.skillflowai.users.core.domain.model.Password;
import com.primeux.skillflowai.users.core.domain.model.Role;
import com.primeux.skillflowai.users.core.domain.model.User;
import com.primeux.skillflowai.users.core.ports.repositories.UserRepository;
import com.primeux.skillflowai.users.core.ports.services.PasswordEncoding;
import com.primeux.skillflowai.users.core.ports.usecases.RegisterUser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class RegisterUserService implements RegisterUser {

    private final UserRepository userRepository;
    private final PasswordEncoding passwordEncoding;


    public User register(RegisterUserCommand registerUserCommand) {
        Email email = Email.of(registerUserCommand.getEmail());
        if (userRepository.existsByEmail(email)) {
            throw new ValidationFailedException(String.format("User with email %s already exists", registerUserCommand.getEmail()));
        }
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
