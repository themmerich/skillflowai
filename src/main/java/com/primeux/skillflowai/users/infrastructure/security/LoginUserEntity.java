package com.primeux.skillflowai.users.infrastructure.security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
class LoginUserEntity {

    @Id
    private UUID id;
    private String tenantId;
    private String email;
    private String password;

}
