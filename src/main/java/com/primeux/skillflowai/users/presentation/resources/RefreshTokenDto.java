package com.primeux.skillflowai.users.presentation.resources;

import jakarta.validation.constraints.NotBlank;

public record RefreshTokenDto(@NotBlank String refreshToken) {
}
