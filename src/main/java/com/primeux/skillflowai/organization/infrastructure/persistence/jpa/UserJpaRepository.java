package com.primeux.skillflowai.organization.infrastructure.persistence.jpa;

import com.primeux.skillflowai.organization.business.domain.model.Email;
import com.primeux.skillflowai.organization.business.domain.model.User;
import com.primeux.skillflowai.organization.business.domain.model.UserId;
import com.primeux.skillflowai.organization.business.ports.out.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class UserJpaRepository implements UserRepository {

    private final SpringDataUserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll().stream().map(userEntityMapper::toUser).toList();
    }

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
