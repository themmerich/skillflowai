package com.primeux.skillflowai.shared.security.controller;

import com.primeux.skillflowai.shared.annotation.SkillflowRestController;
import com.primeux.skillflowai.shared.security.AuthenticationUseCase;
import com.primeux.skillflowai.shared.security.AuthenticationUseCase.LoginUserCommand;
import com.primeux.skillflowai.shared.security.AuthenticationUseCase.LoginUserResponse;
import com.primeux.skillflowai.shared.security.AuthenticationUseCase.RefreshTokenCommand;
import com.primeux.skillflowai.shared.security.AuthenticationUseCase.RefreshTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@SkillflowRestController("/api/auth")
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
