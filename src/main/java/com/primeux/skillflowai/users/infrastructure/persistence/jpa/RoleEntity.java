package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

//@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity {

    @Id
    private String id;

    private String name;

    private Set<PermissionEntity> permissions = new HashSet<>();
}
