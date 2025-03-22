package com.primeux.skillflowai.shared.security;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AuthenticationUseCase {

    LoginUserResponse loginUser(@Valid LoginUserCommand loginUserCommand);

    RefreshTokenResponse refreshToken(@Valid RefreshTokenCommand refreshTokenCommand);


    record LoginUserCommand(@NotBlank String email, @NotBlank String password) {
    }

    record LoginUserResponse(String accessToken, String refreshToken, long expiresInMs) {
    }

    record RefreshTokenCommand(@NotBlank String refreshToken) {
    }

    record RefreshTokenResponse(String accessToken, long expiresInMs) {
    }
}
