package com.primeux.skillflowai.users.domain.model;


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

    public static Email of(String email) {
        return new Email(email);
    }
}
