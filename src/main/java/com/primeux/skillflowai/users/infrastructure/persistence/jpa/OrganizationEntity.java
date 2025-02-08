package com.primeux.skillflowai.users.infrastructure.persistence.jpa;

import com.primeux.skillflowai.app.tenant.TenantAwareEntity;
import com.primeux.skillflowai.app.tenant.TenantAwareEntityListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TenantId;

import java.util.UUID;

@Entity
@Table(name = "organization")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(TenantAwareEntityListener.class)
public class OrganizationEntity implements TenantAwareEntity {

    @Id
    private UUID id;

    @TenantId
    private String tenantId;

    @NotBlank
    private String name;
}
