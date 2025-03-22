package com.primeux.skillflowai.organization.business.ports.out.repositories;

import com.primeux.skillflowai.organization.business.domain.model.Organization;
import com.primeux.skillflowai.organization.business.domain.model.OrganizationId;
import com.primeux.skillflowai.shared.repository.ReadEntityRepository;
import com.primeux.skillflowai.shared.repository.SaveEntityRepository;

public interface OrganizationRepository extends ReadEntityRepository<Organization, OrganizationId>, SaveEntityRepository<Organization> {

}
