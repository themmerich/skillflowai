package com.primeux.skillflowai.users.core.domain.services;

import com.primeux.skillflowai.shared.annotation.UseCase;
import com.primeux.skillflowai.users.core.domain.model.User;
import com.primeux.skillflowai.users.core.domain.model.UserId;
import com.primeux.skillflowai.users.core.ports.repositories.UserRepository;
import com.primeux.skillflowai.users.core.ports.usecases.UserManagement;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
class UserManagementService implements UserManagement {

    private final UserRepository userRepository;

    @Override
    public Optional<User> read(UserId id) {
        return userRepository.findById(id);
    }
}
