package com.primeux.skillflowai.organization.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface SpringDataOrganizationJpaRepository extends JpaRepository<OrganizationEntity, UUID> {
}
