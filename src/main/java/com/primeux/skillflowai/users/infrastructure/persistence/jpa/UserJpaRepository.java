package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import com.primeux.skillflowai.users.business.domain.model.Email;
import com.primeux.skillflowai.users.business.domain.model.User;
import com.primeux.skillflowai.users.business.domain.model.UserId;
import com.primeux.skillflowai.users.business.ports.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserJpaRepository implements UserRepository {

    private final SpringDataUserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;


    @Override
    public Optional<User> findById(UserId userId) {
        return userJpaRepository.findById(userId.id()).map(userEntityMapper::toUser);
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return userJpaRepository.findByEmail(email.email()).map(userEntityMapper::toUser);
    }

    @Override
    public boolean existsByEmail(Email email) {
        return userJpaRepository.existsByEmail(email.email());
    }

    public User save(User user) {
        UserEntity saved = userJpaRepository.save(userEntityMapper.toUserEntity(user));
        return userEntityMapper.toUser(saved);
    }
}
