package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import com.primeux.skillflowai.users.business.domain.model.Email;
import com.primeux.skillflowai.users.business.domain.model.OrganizationId;
import com.primeux.skillflowai.users.business.domain.model.Password;
import com.primeux.skillflowai.users.business.domain.model.UserId;
import org.mapstruct.Named;

import java.util.UUID;

public interface EntityMapper {

    @Named("userId")
    default UserId toUserId(UUID id) {
        return new UserId(id);
    }

    @Named("organizationId")
    default OrganizationId toOrganizationId(String id) {
        return OrganizationId.fromString(id);
    }

    @Named("email")
    default Email toEmail(String email) {
        return Email.of(email);
    }

    @Named("password")
    default Password toPassword(String password) {
        return Password.of(password);
    }

    @Named("uuidAsString")
    default String uuidAsString(UUID id) {
        return id.toString();
    }
}
