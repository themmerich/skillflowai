package com.primeux.skillflowai.training.business.domain.model.quiz;

import java.util.Objects;
import java.util.UUID;

public record AnswerId(UUID id) {
    public AnswerId {
        Objects.requireNonNull(id);
    }

    public AnswerId() {
        this(UUID.randomUUID());
    }
}
