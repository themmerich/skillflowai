package com.primeux.skillflowai.organization.presentation.mapper;

import com.primeux.skillflowai.organization.business.domain.model.User;
import com.primeux.skillflowai.organization.presentation.resources.UserReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserResourcesMapper {

    @Mapping(target = "email", source = "source.email.email")
    @Mapping(target = "id", source = "source.id.id")
    UserReadDto toReadDto(User source);
}
