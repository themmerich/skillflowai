package com.primeux.skillflowai.organization.business.domain.model;

import java.util.Objects;

public record Password(String password) {

    public Password {
        Objects.requireNonNull(password);
    }

    public static Password fromString(String password) {
        if (password == null) {
            return null;
        }
        return new Password(password);
    }
}
