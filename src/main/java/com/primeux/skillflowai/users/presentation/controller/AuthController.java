package com.primeux.skillflowai.users.presentation.controller;

import com.primeux.skillflowai.users.business.ports.usecases.AuthenticationUseCase;
import com.primeux.skillflowai.users.business.ports.usecases.AuthenticationUseCase.LoginUserCommand;
import com.primeux.skillflowai.users.business.ports.usecases.AuthenticationUseCase.LoginUserResponse;
import com.primeux.skillflowai.users.business.ports.usecases.AuthenticationUseCase.RefreshTokenCommand;
import com.primeux.skillflowai.users.business.ports.usecases.AuthenticationUseCase.RefreshTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
@RequiredArgsConstructor
public class AuthController {
     
    private final AuthenticationUseCase authentication;

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    @ResponseBody
    public LoginUserResponse login(@RequestBody LoginUserCommand loginUserCommand) {
        return authentication.loginUser(loginUserCommand);
    }

    @PostMapping("/refresh")
    @PreAuthorize("permitAll()")
    @ResponseBody
    public RefreshTokenResponse refreshToken(@RequestBody RefreshTokenCommand refreshTokenCommand) {
        return authentication.refreshToken(refreshTokenCommand);
    }


}
