package com.primeux.skillflowai.organization.business.ports.out.repositories;

import com.primeux.skillflowai.organization.business.domain.model.Email;
import com.primeux.skillflowai.organization.business.domain.model.User;
import com.primeux.skillflowai.organization.business.domain.model.UserId;
import com.primeux.skillflowai.shared.repository.ReadEntityRepository;
import com.primeux.skillflowai.shared.repository.SaveEntityRepository;

import java.util.Optional;

public interface UserRepository extends ReadEntityRepository<User, UserId>, SaveEntityRepository<User> {

    Optional<User> findByEmail(Email email);

    boolean existsByEmail(Email email);

}
