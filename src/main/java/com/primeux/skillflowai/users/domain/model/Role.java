package com.primeux.skillflowai.users.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Role {

    @Setter
    private String name;
    private final Set<Permission> permissions = new HashSet<>();


    public static Role createTestRole(String permission) {
        Role role = new Role();
        role.setName("Test");
        role.getPermissions().add(createTestPermission(permission));
        return role;
    }

    public static Permission createTestPermission(String permission) {
        return new Permission(permission, "test: " + permission);
    }
}
