package com.primeux.skillflowai.organization.infrastructure.persistence.jpa;

import com.primeux.skillflowai.files.business.domain.model.ImageId;
import com.primeux.skillflowai.organization.business.domain.model.Email;
import com.primeux.skillflowai.organization.business.domain.model.OrganizationId;
import com.primeux.skillflowai.organization.business.domain.model.Password;
import com.primeux.skillflowai.organization.business.domain.model.UserId;
import com.primeux.skillflowai.shared.mapper.SkillflowEntityMapper;
import org.mapstruct.Named;

import java.util.UUID;

interface OrganizationBaseEntityMapper extends SkillflowEntityMapper {

    @Named("userId")
    default UserId toUserId(UUID id) {
        if (id == null) {
            return null;
        }
        return new UserId(id);
    }

    @Named("organizationId")
    default OrganizationId toOrganizationId(String id) {
        return OrganizationId.fromString(id);
    }

    @Named("email")
    default Email toEmail(String email) {
        return Email.fromString(email);
    }

    @Named("password")
    default Password toPassword(String password) {
        return Password.fromString(password);
    }

    @Named("imageId")
    default ImageId toImageId(UUID id) {
        if (id == null) {
            return null;
        }
        return new ImageId(id);
    }

}
