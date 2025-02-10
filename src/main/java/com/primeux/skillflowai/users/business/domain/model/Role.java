package com.primeux.skillflowai.users.business.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Role {

    private final String name;
    private final Set<Permission> permissions = new HashSet<>();

    public void addPermission(Permission permission) {
        permissions.add(permission);
    }

    public void addPermissions(Collection<Permission> permissionsToAdd) {
        permissions.addAll(permissionsToAdd);
    }
}
