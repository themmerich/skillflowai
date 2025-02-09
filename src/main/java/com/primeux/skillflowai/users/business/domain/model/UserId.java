package com.primeux.skillflowai.users.business.domain.model;

import java.util.Objects;
import java.util.UUID;

public record UserId(UUID id) {

    public UserId {
        Objects.requireNonNull(id);
    }

    public UserId() {
        this(UUID.randomUUID());
    }

    public static UserId of(String uuid) {
        return new UserId(UUID.fromString(uuid));
    }
}
