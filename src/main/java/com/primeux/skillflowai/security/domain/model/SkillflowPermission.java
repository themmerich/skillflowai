package com.primeux.skillflowai.security.domain.model;

public interface SkillflowPermission {
    public static final String DENY_ALL = "denyAll()";
    public static final String PERMIT_ALL = "permitAll()";

    String getCode();
}
