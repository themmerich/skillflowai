package com.primeux.skillflowai.users.domain.model;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Role {

    private String name;
    private final Set<Permission> permissions = new HashSet<>();

}
