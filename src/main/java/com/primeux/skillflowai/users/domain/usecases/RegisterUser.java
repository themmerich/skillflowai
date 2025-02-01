package com.primeux.skillflowai.users.domain.usecases;

import com.primeux.skillflowai.users.domain.model.User;
import com.primeux.skillflowai.users.domain.registration.RegisterUserRequest;

public interface RegisterUser {
    User register(RegisterUserRequest request);
}
