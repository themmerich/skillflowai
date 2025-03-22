package com.primeux.skillflowai.organization.business.ports.in.usecases;

import com.primeux.skillflowai.organization.business.domain.model.Organization;
import com.primeux.skillflowai.organization.business.domain.model.OrganizationId;
import com.primeux.skillflowai.shared.usecase.ReadEntityUseCase;

public interface ReadOrganizationUseCase extends ReadEntityUseCase<Organization, OrganizationId> {

}
