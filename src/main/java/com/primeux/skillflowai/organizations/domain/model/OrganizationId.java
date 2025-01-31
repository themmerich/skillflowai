package com.primeux.skillflowai.organizations.domain.model;

import java.util.Objects;
import java.util.UUID;

public record OrganizationId(UUID id) {
    public OrganizationId {
        Objects.requireNonNull(id);
    }

    public OrganizationId() {
        this(UUID.randomUUID());
    }
}
