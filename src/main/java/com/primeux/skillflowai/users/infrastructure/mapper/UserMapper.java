package com.primeux.skillflowai.users.infrastructure.mapper;

import com.primeux.skillflowai.users.domain.model.Email;
import com.primeux.skillflowai.users.domain.model.Password;
import com.primeux.skillflowai.users.domain.model.User;
import com.primeux.skillflowai.users.domain.model.UserId;
import com.primeux.skillflowai.users.infrastructure.db.jpa.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "id", source = "id", qualifiedByName = "userId")
    @Mapping(target = "email", source = "email", qualifiedByName = "email")
    @Mapping(target = "password", source = "password", qualifiedByName = "password")
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "organizationId", ignore = true)
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
}
