package com.primeux.skillflowai.users.infrastructure.db.jpa;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

//@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PermissionEntity {

    @Id
    private UUID id;

    @NotBlank
    private String code;
    private String description;
}
