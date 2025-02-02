package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

//@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoleEntity {

    @Id
    private UUID id;

    @NotBlank
    private String name;

    private Set<PermissionEntity> permissions = new HashSet<>();
}
