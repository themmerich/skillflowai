package com.primeux.skillflowai.organization.business.domain.services;

import com.primeux.skillflowai.organization.business.domain.model.Email;
import com.primeux.skillflowai.organization.business.domain.model.User;
import com.primeux.skillflowai.organization.business.domain.model.UserId;
import com.primeux.skillflowai.organization.business.ports.in.usecases.ReadUserUseCase;
import com.primeux.skillflowai.organization.business.ports.in.usecases.UpdateUserUseCase;
import com.primeux.skillflowai.organization.business.ports.out.repositories.UserRepository;
import com.primeux.skillflowai.shared.annotation.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@UseCase
@RequiredArgsConstructor
class UserCrudService implements ReadUserUseCase, UpdateUserUseCase {

    private final UserRepository userRepository;

    @Override
    public Optional<User> read(UserId id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }


    @Override
    public void update(UpdateUserCommand command) {
        User userToUpdate = userRepository.findById(UserId.fromString(command.id())).orElseThrow(() -> new RuntimeException("User does not exist: id=" + command.id()));
        userToUpdate.setEmail(Email.fromString(command.email()));
        userToUpdate.setFirstName(command.firstName());
        userToUpdate.setLastName(command.lastName());
        userToUpdate.setBirthday(command.birthday());
        userRepository.save(userToUpdate);
    }
}
