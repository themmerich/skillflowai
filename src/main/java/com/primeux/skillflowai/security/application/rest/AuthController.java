package com.primeux.skillflowai.security.application.rest;

import com.primeux.skillflowai.security.application.dto.LoginResponseDto;
import com.primeux.skillflowai.security.application.dto.LoginUserDto;
import com.primeux.skillflowai.security.domain.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
@RequiredArgsConstructor
public class AuthController {


    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    @ResponseBody
    public LoginResponseDto login(@RequestBody LoginUserDto loginUserDto) {
        return authenticationService.authenticate(loginUserDto);

    }


}
