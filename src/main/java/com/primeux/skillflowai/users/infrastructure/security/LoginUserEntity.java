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

    //TODO: User ohne Tenant, stattdessen eine Liste von allen Organisationen laden.
    // Wenn beim Login der User mehr als einen Tenant hat, dann eine Auswahl mit den erlaubten Tenants in die Claims und zurückgeben
    // bei jedem Request den aktuellen Tenant in den Header packen und mitliefern. Dann auch im Backend immer prüfen, ob der übergebene Tenant zu dem User gehört

    @Id
    private UUID id;
    private String tenantId;
    private String email;
    private String password;

}
