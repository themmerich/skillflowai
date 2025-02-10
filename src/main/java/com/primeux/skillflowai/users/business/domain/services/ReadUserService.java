package com.primeux.skillflowai.users.business.domain.services;

import com.primeux.skillflowai.shared.annotation.UseCase;
import com.primeux.skillflowai.users.business.domain.model.User;
import com.primeux.skillflowai.users.business.domain.model.UserId;
import com.primeux.skillflowai.users.business.ports.repositories.UserRepository;
import com.primeux.skillflowai.users.business.ports.usecases.ReadUserUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@UseCase
@RequiredArgsConstructor
class ReadUserService implements ReadUserUseCase {

    private final UserRepository userRepository;

    @Override
    public Optional<User> read(UserId id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }


}
