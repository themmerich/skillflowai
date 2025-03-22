package com.primeux.skillflowai.organization.infrastructure.persistence.jpa;

import com.primeux.skillflowai.organization.business.domain.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
interface OrganizationEntityMapper extends OrganizationBaseEntityMapper {

    @Mapping(target = "id", source = "id.id")
    @Mapping(target = "tenantId", source = "id.id", qualifiedByName = "uuidAsString")
    @Mapping(target = "image", source = "image.id")
    OrganizationEntity toOrganizationEntity(Organization organization);

    @Mapping(target = "id", source = "id", qualifiedByName = "organizationId")
    @Mapping(target = "image", source = "image", qualifiedByName = "imageId")
    Organization toOrganization(OrganizationEntity organizationEntity);
}
