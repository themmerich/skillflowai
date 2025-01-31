package com.primeux.skillflowai.users.domain.model;

import java.util.Objects;
import java.util.UUID;

public record UserId(UUID id) {

    public UserId {
        Objects.requireNonNull(id);
    }

    public UserId() {
        this(UUID.randomUUID());
    }
}
