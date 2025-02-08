package com.primeux.skillflowai.users.infrastructure.security;

import com.primeux.skillflowai.users.core.domain.model.Permission;
import com.primeux.skillflowai.users.core.domain.model.Role;
import com.primeux.skillflowai.users.core.domain.model.User;
import com.primeux.skillflowai.users.core.ports.usecases.Authentication;
import com.primeux.skillflowai.users.presentation.resources.LoginResponseDto;
import com.primeux.skillflowai.users.presentation.resources.LoginUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SpringSecurityAuthentication implements Authentication {

    private final JwtUtils jwtUtils;
    private final SpringDataLoginUserRepository springDataLoginUserRepository;
    private final AuthenticationManager authenticationManager;
    private final LoginUserEntityMapper userEntityMapper;

    public LoginResponseDto authenticate(LoginUserDto loginUserDto) {
        SkillflowUserDetails userDetails = getUserDetails(loginUserDto);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails, loginUserDto.getPassword(), userDetails.getAuthorities()));
        String token = jwtUtils.generateToken(userDetails);
        return new LoginResponseDto(token, jwtUtils.getExpirationInMs());
    }

    private SkillflowUserDetails getUserDetails(LoginUserDto loginUserDto) {
        User user = springDataLoginUserRepository.findByEmail(loginUserDto.getEmail()).map(userEntityMapper::toUser).orElseThrow();
        //User user = userRepository.findByEmail(Email.of(loginUserDto.getEmail())).orElseThrow(() -> new RuntimeException(String.format("User %s not found", loginUserDto.getEmail())));
        user.getRoles().add(createTestRole("USER_READ"));
        return new SkillflowUserDetails(user);
    }

    //TODO Permissions aus der DB auslesen und setzen
    private Role createTestRole(String permission) {
        Role role = new Role();
        role.getPermissions().add(createTestPermission(permission));
        return role;
    }

    private Permission createTestPermission(String permission) {
        return new Permission(permission, "test: " + permission);
    }
}
