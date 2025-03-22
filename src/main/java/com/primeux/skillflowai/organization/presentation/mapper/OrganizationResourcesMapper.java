package com.primeux.skillflowai.organization.presentation.mapper;

import com.primeux.skillflowai.organization.business.domain.model.Organization;
import com.primeux.skillflowai.organization.presentation.resources.OrganizationReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrganizationResourcesMapper {

    @Mapping(target = "id", source = "source.id.id")
    @Mapping(target = "image", source = "image.id")
    OrganizationReadDto toReadDto(Organization source);


}
