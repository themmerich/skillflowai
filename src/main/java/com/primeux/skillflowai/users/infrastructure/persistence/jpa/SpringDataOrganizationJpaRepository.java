package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataOrganizationJpaRepository extends JpaRepository<OrganizationEntity, UUID> {
}
