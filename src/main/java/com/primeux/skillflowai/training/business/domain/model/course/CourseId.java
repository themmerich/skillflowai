package com.primeux.skillflowai.training.business.domain.model.course;

import java.util.Objects;
import java.util.UUID;

public record CourseId(UUID id) {
    public CourseId {
        Objects.requireNonNull(id);
    }

    public CourseId() {
        this(UUID.randomUUID());
    }

    public static CourseId fromString(String uuid) {
        return new CourseId(UUID.fromString(uuid));
    }
}
