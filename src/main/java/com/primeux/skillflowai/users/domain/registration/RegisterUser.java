package com.primeux.skillflowai.users.domain.registration;

import com.primeux.skillflowai.common.domain.UseCase;
import com.primeux.skillflowai.security.domain.service.PasswordEncodingService;
import com.primeux.skillflowai.users.domain.model.*;
import com.primeux.skillflowai.users.domain.permission.UserPermission;
import com.primeux.skillflowai.users.domain.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
@UseCase
public class RegisterUser {

    private final UserRepository userRepository;
    private final PasswordEncodingService passwordEncodingService;


    public User register(RegisterUserRequest request) {
        Email email = Email.of(request.getEmail());
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new ConstraintViolationException(String.format("User with email %s already exists", request.getEmail()), Collections.emptySet());
        }
        User newUser = new User();
        newUser.setId(new UserId());
        newUser.setEmail(email);
        newUser.setPassword(Password.of(passwordEncodingService.encode(request.getPassword())));
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.getRoles().add(Role.createTestRole(UserPermission.USER_READ));
        //TODO: Confirmation-Email an User schicken, Login erst dann möglich
        return userRepository.save(newUser);
    }
}
