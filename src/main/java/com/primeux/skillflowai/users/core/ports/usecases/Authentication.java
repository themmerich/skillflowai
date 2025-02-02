package com.primeux.skillflowai.users.core.ports.usecases;

import com.primeux.skillflowai.users.presentation.resources.LoginResponseDto;
import com.primeux.skillflowai.users.presentation.resources.LoginUserDto;

public interface Authentication {

    LoginResponseDto authenticate(LoginUserDto loginUserDto);
}
