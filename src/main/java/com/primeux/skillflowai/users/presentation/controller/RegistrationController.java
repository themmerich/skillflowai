package com.primeux.skillflowai.users.presentation.controller;

import com.primeux.skillflowai.users.business.ports.usecases.RegisterUserUseCase;
import com.primeux.skillflowai.users.business.ports.usecases.RegisterUserUseCase.RegisterUserCommand;
import com.primeux.skillflowai.users.presentation.mapper.UserResourcesMapper;
import com.primeux.skillflowai.users.presentation.resources.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegisterUserUseCase registerUserUseCase;
    private final UserResourcesMapper userMapper;

    @PostMapping("/register")
    @ResponseBody
    public UserReadDto registerUser(@RequestBody RegisterUserCommand request) {
        return userMapper.toReadDto(registerUserUseCase.register(request));
    }
}
