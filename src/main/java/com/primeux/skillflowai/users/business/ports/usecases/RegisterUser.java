package com.primeux.skillflowai.users.business.ports.usecases;

import com.primeux.skillflowai.users.business.domain.model.User;
import com.primeux.skillflowai.users.business.domain.services.RegisterUserCommand;

public interface RegisterUser {

    User register(RegisterUserCommand command);
}
