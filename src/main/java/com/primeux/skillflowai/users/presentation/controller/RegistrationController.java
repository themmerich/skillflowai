package com.primeux.skillflowai.users.presentation.controller;

import com.primeux.skillflowai.users.core.domain.model.User;
import com.primeux.skillflowai.users.core.domain.services.RegisterUserCommand;
import com.primeux.skillflowai.users.core.domain.services.RegisterUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegisterUserService registerUserService;

    @PostMapping("/register")
    @ResponseBody
    public User registerUser(@RequestBody RegisterUserCommand request) {
        return registerUserService.register(request);
    }
}
