package com.primeux.skillflowai.organization.infrastructure.persistence.jpa;

import com.primeux.skillflowai.organization.business.domain.model.Organization;
import com.primeux.skillflowai.organization.business.domain.model.OrganizationId;
import com.primeux.skillflowai.organization.business.ports.out.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class OrganizationJpaRepository implements OrganizationRepository {
    private final SpringDataOrganizationJpaRepository organizationJpaRepository;
    private final OrganizationEntityMapper organizationEntityMapper;

    @Override
    public Organization save(Organization organization) {
        OrganizationEntity saved = organizationJpaRepository.save(organizationEntityMapper.toOrganizationEntity(organization));
        return organizationEntityMapper.toOrganization(saved);
    }

    @Override
    public Optional<Organization> findById(OrganizationId organizationId) {
        return organizationJpaRepository.findById(organizationId.id()).map(organizationEntityMapper::toOrganization);
    }

    @Override
    public List<Organization> findAll() {
        return organizationJpaRepository.findAll().stream().map(organizationEntityMapper::toOrganization).toList();
    }
}
