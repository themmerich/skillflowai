package com.primeux.skillflowai.users.infrastructure.security;

import com.primeux.skillflowai.users.business.domain.model.User;
import com.primeux.skillflowai.users.infrastructure.persistence.jpa.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoginUserEntityMapper extends EntityMapper {

    @Mapping(target = "id", source = "id", qualifiedByName = "userId")
    @Mapping(target = "email", source = "email", qualifiedByName = "email")
    @Mapping(target = "password", source = "password", qualifiedByName = "password")
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "organizationId", source = "tenantId", qualifiedByName = "organizationId")
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    User toUser(LoginUserEntity source);
}
