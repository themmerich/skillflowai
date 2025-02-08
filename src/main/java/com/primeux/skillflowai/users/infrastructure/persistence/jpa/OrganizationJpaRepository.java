package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import com.primeux.skillflowai.users.core.domain.model.Organization;
import com.primeux.skillflowai.users.core.ports.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizationJpaRepository implements OrganizationRepository {
    private final SpringDataOrganizationJpaRepository organizationJpaRepository;
    private final OrganizationEntityMapper organizationEntityMapper;

    @Override
    public Organization save(Organization organization) {
        OrganizationEntity saved = organizationJpaRepository.save(organizationEntityMapper.toOrganizationEntity(organization));
        return organizationEntityMapper.toOrganization(saved);
    }
}
