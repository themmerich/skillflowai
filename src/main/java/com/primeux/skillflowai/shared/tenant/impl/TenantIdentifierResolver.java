package com.primeux.skillflowai.shared.tenant.impl;

import com.primeux.skillflowai.shared.tenant.TenantContext;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
class TenantIdentifierResolver implements CurrentTenantIdentifierResolver<String>, HibernatePropertiesCustomizer {

    @Override
    public String resolveCurrentTenantIdentifier() {
        if (TenantContext.getCurrentTenant() != null) {
            return TenantContext.getCurrentTenant();
        }
        String tenantId = UUID.randomUUID().toString();
        TenantContext.setCurrentTenant(tenantId);
        return tenantId;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }


    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
    }
}
