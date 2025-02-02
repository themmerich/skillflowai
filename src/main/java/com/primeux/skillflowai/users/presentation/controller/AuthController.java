package com.primeux.skillflowai.users.presentation.controller;

import com.primeux.skillflowai.users.core.ports.usecases.Authentication;
import com.primeux.skillflowai.users.presentation.resources.LoginResponseDto;
import com.primeux.skillflowai.users.presentation.resources.LoginUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
@RequiredArgsConstructor
public class AuthController {


    private final Authentication authentication;

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    @ResponseBody
    public LoginResponseDto login(@RequestBody LoginUserDto loginUserDto) {
        return authentication.authenticate(loginUserDto);
    }


}
