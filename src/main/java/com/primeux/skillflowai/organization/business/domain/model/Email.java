package com.primeux.skillflowai.organization.business.domain.model;


import java.util.Objects;

public record Email(String email) {

    public Email {
        Objects.requireNonNull(email);
        //TODO: Check for email pattern?
    }

    @Override
    public String toString() {
        return email;
    }

    public static Email fromString(String email) {
        if (email == null) {
            return null;
        }
        return new Email(email);
    }
}
