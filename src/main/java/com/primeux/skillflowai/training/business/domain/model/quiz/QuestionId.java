package com.primeux.skillflowai.training.business.domain.model.quiz;

import java.util.Objects;
import java.util.UUID;

public record QuestionId(UUID id) {

    public QuestionId {
        Objects.requireNonNull(id);
    }

    public QuestionId() {
        this(UUID.randomUUID());
    }

}
