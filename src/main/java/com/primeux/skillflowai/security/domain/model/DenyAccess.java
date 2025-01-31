package com.primeux.skillflowai.security.domain.model;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("denyAll()")
public @interface DenyAccess {
}
