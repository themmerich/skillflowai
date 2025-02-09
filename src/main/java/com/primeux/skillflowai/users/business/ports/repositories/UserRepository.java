package com.primeux.skillflowai.users.business.ports.repositories;

import com.primeux.skillflowai.users.business.domain.model.Email;
import com.primeux.skillflowai.users.business.domain.model.User;
import com.primeux.skillflowai.users.business.domain.model.UserId;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(UserId userId);

    Optional<User> findByEmail(Email email);

    boolean existsByEmail(Email email);

    User save(User user);
}
