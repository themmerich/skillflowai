package com.primeux.skillflowai.organization.presentation.controller;

import com.primeux.skillflowai.organization.business.ports.in.usecases.RegisterUserUseCase;
import com.primeux.skillflowai.organization.business.ports.in.usecases.RegisterUserUseCase.RegisterUserCommand;
import com.primeux.skillflowai.shared.annotation.SkillflowRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.primeux.skillflowai.shared.security.CommonAuthorities.PERMIT_ALL;

@SkillflowRestController("/api/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping
    @ResponseBody
    @PreAuthorize(PERMIT_ALL)
    public boolean registerUser(@RequestBody RegisterUserCommand request) {
        return registerUserUseCase.register(request);
    }
}
