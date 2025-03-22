package com.primeux.skillflowai.organization.business.domain.model;

import java.util.Objects;
import java.util.UUID;

public record OrganizationId(UUID id) {

    public OrganizationId {
        Objects.requireNonNull(id);
    }

    public OrganizationId() {
        this(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return id.toString();
    }

    public static OrganizationId fromString(String uuid) {
        if (uuid == null) {
            return null;
        }
        return new OrganizationId(UUID.fromString(uuid));
    }

}
