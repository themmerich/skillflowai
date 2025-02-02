package com.primeux.skillflowai.users.core.ports.usecases;

import com.primeux.skillflowai.users.core.domain.model.User;
import com.primeux.skillflowai.users.core.domain.services.RegisterUserCommand;

public interface RegisterUser {

    User register(RegisterUserCommand command);
}
