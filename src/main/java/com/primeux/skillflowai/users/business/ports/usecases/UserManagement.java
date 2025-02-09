package com.primeux.skillflowai.users.business.ports.usecases;

import com.primeux.skillflowai.users.business.domain.model.User;
import com.primeux.skillflowai.users.business.domain.model.UserId;

import java.util.Optional;

public interface UserManagement {

    Optional<User> read(UserId id);
}
