package com.primeux.skillflowai.files.business.domain.model;

import java.util.Objects;
import java.util.UUID;

public record ImageId(UUID id) {
    public ImageId {
        Objects.requireNonNull(id);
    }

    public ImageId() {
        this(UUID.randomUUID());
    }

    public static ImageId fromString(String uuid) {
        return new ImageId(UUID.fromString(uuid));
    }
}
