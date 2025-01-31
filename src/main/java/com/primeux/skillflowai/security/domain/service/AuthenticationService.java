package com.primeux.skillflowai.security.domain.service;

import com.primeux.skillflowai.security.application.dto.LoginResponseDto;
import com.primeux.skillflowai.security.application.dto.LoginUserDto;

public interface AuthenticationService {

    LoginResponseDto authenticate(LoginUserDto loginUserDto);
}
