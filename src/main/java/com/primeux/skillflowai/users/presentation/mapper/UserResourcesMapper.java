package com.primeux.skillflowai.users.presentation.mapper;

import com.primeux.skillflowai.users.core.domain.model.User;
import com.primeux.skillflowai.users.presentation.resources.UserReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserResourcesMapper {

    @Mapping(target = "email", source = "source.email.email")
    UserReadDto toReadDto(User source);
}
