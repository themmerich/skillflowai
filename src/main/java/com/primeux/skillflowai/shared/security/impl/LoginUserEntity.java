package com.primeux.skillflowai.shared.security.impl;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
class LoginUserEntity {

    //TODO: User ohne Tenant, stattdessen eine Liste von allen Organisationen laden.
    // Wenn beim Login der User mehr als einen Tenant hat, dann eine Auswahl mit den erlaubten Tenants in die Claims und zurückgeben
    // bei jedem Request den aktuellen Tenant in den Header packen und mitliefern. Dann auch im Backend immer prüfen, ob der übergebene Tenant zu dem User gehört

    @Id
    private UUID id;
    private String tenantId;
    private String email;
    private String password;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_id")
    private Set<String> roles = new HashSet<>();
}
