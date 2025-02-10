package com.primeux.skillflowai.users.infrastructure.security;

import com.primeux.skillflowai.shared.validation.ValidationFailedException;
import com.primeux.skillflowai.users.business.domain.model.User;
import com.primeux.skillflowai.users.business.ports.usecases.AuthenticationUseCase;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SpringSecurityAuthentication implements AuthenticationUseCase {

    private final JwtUtils jwtUtils;
    private final SpringDataLoginUserRepository springDataLoginUserRepository;
    private final AuthenticationManager authenticationManager;
    private final LoginUserEntityMapper userEntityMapper;

    public LoginUserResponse loginUser(LoginUserCommand loginUserCommand) {
        SkillflowUserDetails userDetails = getUserDetails(loginUserCommand.email());

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails, loginUserCommand.password(), userDetails.getAuthorities()));
        String accessToken = jwtUtils.generateAccessToken(userDetails);
        String refreshToken = jwtUtils.generateRefreshToken(userDetails);
        return new LoginUserResponse(accessToken, refreshToken, jwtUtils.getExpirationAccessInMs());
    }

    public RefreshTokenResponse refreshToken(RefreshTokenCommand refreshTokenDto) {
        String refreshToken = refreshTokenDto.refreshToken();

        if (refreshToken == null) {
            throw new ValidationFailedException("Refresh Token is required.");
        }

        try {
            if (jwtUtils.validateToken(refreshToken)) {
                String username = jwtUtils.getUsernameFromToken(refreshToken);
                SkillflowUserDetails userDetails = getUserDetails(username);
                String accessToken = jwtUtils.generateAccessToken(userDetails);
                return new RefreshTokenResponse(accessToken, jwtUtils.getExpirationAccessInMs());
            }
            throw new ValidationFailedException("Invalid refresh token");
        } catch (JwtException e) {
            throw new ValidationFailedException("Invalid refresh token");
        }
    }

    private SkillflowUserDetails getUserDetails(String username) {
        User user = springDataLoginUserRepository.findByEmail(username).map(userEntityMapper::toUser).orElseThrow();
        return new SkillflowUserDetails(user);
    }
}
