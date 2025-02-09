package com.primeux.skillflowai.users.business.ports.repositories;

import com.primeux.skillflowai.users.business.domain.model.Organization;

public interface OrganizationRepository {

    Organization save(Organization organization);
}
