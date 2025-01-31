package com.primeux.skillflowai.users.infrastructure.db.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    private UUID id;
    //private UUID organizationId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @Transient
    private Set<RoleEntity> roles = new HashSet<>();


}
