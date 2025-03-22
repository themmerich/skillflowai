package com.primeux.skillflowai.organization.business.domain.model;

import java.util.Objects;
import java.util.UUID;

public record UserId(UUID id) {

    public UserId {
        Objects.requireNonNull(id);
    }

    public UserId() {
        this(UUID.randomUUID());
    }

    public static UserId fromString(String uuid) {
        if (uuid == null) {
            return null;
        }
        return new UserId(UUID.fromString(uuid));
    }
}
