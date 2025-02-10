package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import com.primeux.skillflowai.users.business.domain.Roles;
import com.primeux.skillflowai.users.business.domain.model.Role;
import com.primeux.skillflowai.users.business.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper extends EntityMapper {


    @Mapping(target = "id", source = "id", qualifiedByName = "userId")
    @Mapping(target = "email", source = "email", qualifiedByName = "email")
    @Mapping(target = "password", source = "password", qualifiedByName = "password")
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "organizationId", source = "tenantId", qualifiedByName = "organizationId")
    @Mapping(target = "status", ignore = true)
    User toUser(UserEntity source);

    List<Role> map(List<String> roleNames);

    default Role map(String roleName) {
        return Roles.getRole(roleName);
    }

    @Mapping(target = "id", source = "id.id")
    @Mapping(target = "email", source = "source.email.email")
    @Mapping(target = "password", source = "source.password.password")
    //@Mapping(target = "roles", qualifiedByName = "stringRoles")
    @Mapping(target = "tenantId", ignore = true)
    UserEntity toUserEntity(User source);

    List<String> mapRoles(List<Role> roles);

    default String map(Role role) {
        if (role == null) {
            return null;
        }
        return role.getName().toUpperCase();
    }
}
