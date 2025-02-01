package com.primeux.skillflowai.security.infrastructure.security;

import com.primeux.skillflowai.security.application.dto.LoginResponseDto;
import com.primeux.skillflowai.security.application.dto.LoginUserDto;
import com.primeux.skillflowai.security.domain.service.AuthenticationService;
import com.primeux.skillflowai.users.domain.model.Email;
import com.primeux.skillflowai.users.domain.model.Permission;
import com.primeux.skillflowai.users.domain.model.Role;
import com.primeux.skillflowai.users.domain.model.User;
import com.primeux.skillflowai.users.domain.permission.UserPermission;
import com.primeux.skillflowai.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SpringSecurityAuthenticationService implements AuthenticationService {

    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public LoginResponseDto authenticate(LoginUserDto loginUserDto) {
        SkillflowUserDetails userDetails = getUserDetails(loginUserDto);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword(), userDetails.getAuthorities()));
        String token = jwtUtils.generateToken(userDetails);
        return new LoginResponseDto(token, jwtUtils.getExpirationInMs());
    }

    private SkillflowUserDetails getUserDetails(LoginUserDto loginUserDto) {
        User user = userRepository.findByEmail(Email.of(loginUserDto.getEmail())).orElseThrow(() -> new RuntimeException(String.format("User %s not found", loginUserDto.getEmail())));
        user.getRoles().add(createTestRole(UserPermission.USER_READ));
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
