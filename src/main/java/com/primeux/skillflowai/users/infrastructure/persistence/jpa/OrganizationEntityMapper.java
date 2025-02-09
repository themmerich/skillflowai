package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import com.primeux.skillflowai.users.business.domain.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrganizationEntityMapper extends EntityMapper {

    @Mapping(target = "id", source = "id.id")
    @Mapping(target = "tenantId", source = "id.id", qualifiedByName = "uuidAsString")
    OrganizationEntity toOrganizationEntity(Organization organization);

    @Mapping(target = "id", source = "id", qualifiedByName = "organizationId")
    Organization toOrganization(OrganizationEntity organizationEntity);
}
