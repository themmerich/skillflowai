package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import com.primeux.skillflowai.users.core.domain.model.Email;
import com.primeux.skillflowai.users.core.domain.model.Password;
import com.primeux.skillflowai.users.core.domain.model.User;
import com.primeux.skillflowai.users.core.domain.model.UserId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {


    @Mapping(target = "id", source = "id", qualifiedByName = "userId")
    @Mapping(target = "email", source = "email", qualifiedByName = "email")
    @Mapping(target = "password", source = "password", qualifiedByName = "password")
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "organizationId", ignore = true)
    @Mapping(target = "status", ignore = true)
    User toUser(UserEntity source);

    @Named("userId")
    default UserId toUserId(UUID id) {
        return new UserId(id);
    }

    @Named("email")
    default Email toEmail(String email) {
        return Email.of(email);
    }

    @Named("password")
    default Password toPassword(String password) {
        return Password.of(password);
    }

    @Mapping(target = "id", source = "id.id")
    @Mapping(target = "email", source = "source.email.email")
    @Mapping(target = "password", source = "source.password.password")
    @Mapping(target = "roles", ignore = true)
    UserEntity toUserEntity(User source);
}
