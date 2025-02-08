package com.primeux.skillflowai.app.tenant;

public interface TenantAwareEntity {

    public String getTenantId();

    public void setTenantId(String tenantId);
}
