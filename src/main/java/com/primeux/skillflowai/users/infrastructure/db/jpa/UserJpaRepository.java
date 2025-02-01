package com.primeux.skillflowai.users.infrastructure.db.jpa;

import com.primeux.skillflowai.users.domain.model.Email;
import com.primeux.skillflowai.users.domain.model.User;
import com.primeux.skillflowai.users.domain.model.UserId;
import com.primeux.skillflowai.users.domain.repository.UserRepository;
import com.primeux.skillflowai.users.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class UserJpaRepository implements UserRepository {

    private final SpringDataUserJpaRepository userJpaRepository;
    private final UserMapper userMapper;


    @Override
    public Optional<User> findById(UserId userId) {
        return userJpaRepository.findById(userId.id()).map(userMapper::toUser);
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return userJpaRepository.findByEmail(email.email()).map(userMapper::toUser);
    }

    public User save(User user) {
        UserEntity saved = userJpaRepository.save(userMapper.toUserEntity(user));
        return userMapper.toUser(saved);
    }
}
