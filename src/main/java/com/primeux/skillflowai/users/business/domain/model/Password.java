package com.primeux.skillflowai.users.business.domain.model;

import java.util.Objects;

public record Password(String password) {

    public Password {
        Objects.requireNonNull(password);
    }

    public static Password of(String password) {
        return new Password(password);
    }
}
