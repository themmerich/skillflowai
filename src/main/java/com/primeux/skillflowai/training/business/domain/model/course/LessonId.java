package com.primeux.skillflowai.training.business.domain.model.course;

import java.util.Objects;
import java.util.UUID;

public record LessonId(UUID id) {
    public LessonId {
        Objects.requireNonNull(id);
    }

    public LessonId() {
        this(UUID.randomUUID());
    }

    public static LessonId fromString(String uuid) {
        return new LessonId(UUID.fromString(uuid));
    }
}
