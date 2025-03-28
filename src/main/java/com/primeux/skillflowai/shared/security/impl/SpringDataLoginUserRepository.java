package com.primeux.skillflowai.shared.security.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

interface SpringDataLoginUserRepository extends JpaRepository<LoginUserEntity, UUID> {
    Optional<LoginUserEntity> findByEmail(String email);
}
