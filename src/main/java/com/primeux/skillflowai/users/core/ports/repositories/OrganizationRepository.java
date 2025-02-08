package com.primeux.skillflowai.users.core.ports.repositories;

import com.primeux.skillflowai.users.core.domain.model.Organization;

public interface OrganizationRepository {

    Organization save(Organization organization);
}
