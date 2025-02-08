package com.primeux.skillflowai.app.tenant;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Objects;

public class TenantAwareEntityListener {

    @PrePersist
    void beforeCreate(TenantAwareEntity entity) {
        entity.setTenantId(TenantContext.getCurrentTenant());

    }

    @PreUpdate
    void beforeUpdate(TenantAwareEntity entity) {
        if (entity.getTenantId() == null || !Objects.equals(entity.getTenantId(), TenantContext.getCurrentTenant())) {
            throw new RuntimeException("Entity must have tenantId and it must match the current tenant context");
        }
    }
}
