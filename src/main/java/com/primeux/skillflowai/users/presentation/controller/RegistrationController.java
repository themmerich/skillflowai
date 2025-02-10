package com.primeux.skillflowai.users.presentation.controller;

import com.primeux.skillflowai.users.business.domain.model.User;
import com.primeux.skillflowai.users.business.ports.usecases.RegisterUserUseCase;
import com.primeux.skillflowai.users.business.ports.usecases.RegisterUserUseCase.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/register")
    @ResponseBody
    public User registerUser(@RequestBody RegisterUserCommand request) {
        return registerUserUseCase.register(request);
    }
}
