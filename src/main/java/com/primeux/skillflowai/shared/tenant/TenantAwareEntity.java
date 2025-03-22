package com.primeux.skillflowai.shared.tenant;

public interface TenantAwareEntity {

    String getTenantId();

    void setTenantId(String tenantId);
}
