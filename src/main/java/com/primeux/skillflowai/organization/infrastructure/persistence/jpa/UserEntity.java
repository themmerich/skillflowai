package com.primeux.skillflowai.organization.infrastructure.persistence.jpa;

import com.primeux.skillflowai.shared.tenant.TenantAwareEntity;
import com.primeux.skillflowai.shared.tenant.TenantAwareEntityListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TenantId;

import java.time.LocalDate;
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
    @TenantId
    private String tenantId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_id")
    private Set<String> roles = new HashSet<>();


}
