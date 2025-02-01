package com.primeux.skillflowai.users.domain.repository;

import com.primeux.skillflowai.users.domain.model.Email;
import com.primeux.skillflowai.users.domain.model.User;
import com.primeux.skillflowai.users.domain.model.UserId;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(UserId userId);

    Optional<User> findByEmail(Email email);

    public User save(User user);
}
