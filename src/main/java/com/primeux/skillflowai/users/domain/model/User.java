package com.primeux.skillflowai.users.domain.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    private UserId id;
    private String organizationId;
    private Email email;
    private Password password;
    private String firstName;
    private String lastName;

    private final Set<Role> roles = new HashSet<>();
}
