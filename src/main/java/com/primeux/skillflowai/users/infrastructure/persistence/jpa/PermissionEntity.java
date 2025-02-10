package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
public class PermissionEntity {

    @Id
    private String code;
    private String description;
}
