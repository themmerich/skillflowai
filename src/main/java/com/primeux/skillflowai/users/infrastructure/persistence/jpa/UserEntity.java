package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import com.primeux.skillflowai.app.tenant.TenantAwareEntity;
import com.primeux.skillflowai.app.tenant.TenantAwareEntityListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TenantId;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(TenantAwareEntityListener.class)
public class UserEntity implements TenantAwareEntity {
    @Id
    private UUID id;
    @NotBlank
    @TenantId
    private String tenantId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @Transient
    private Set<RoleEntity> roles = new HashSet<>();


}
