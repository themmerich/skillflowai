package com.primeux.skillflowai.files.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataImageJpaRepository extends JpaRepository<ImageEntity, UUID> {
}
