package com.primeux.skillflowai.users.core.ports.usecases;

import com.primeux.skillflowai.users.core.domain.model.User;
import com.primeux.skillflowai.users.core.domain.model.UserId;

import java.util.Optional;

public interface UserManagement {

    Optional<User> read(UserId id);
}
