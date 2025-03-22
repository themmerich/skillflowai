package com.primeux.skillflowai.training.business.domain.model.quiz;

import java.util.Objects;
import java.util.UUID;

public record QuizId(UUID id) {
    public QuizId {
        Objects.requireNonNull(id);
    }

    public QuizId() {
        this(UUID.randomUUID());
    }
}
