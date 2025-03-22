package com.primeux.skillflowai.organization.presentation.controller;

import com.primeux.skillflowai.shared.security.CommonAuthorities;

class OrganizationAuthorities extends CommonAuthorities {
    static final String READ_ORGANIZATION = "hasAuthority('ORGANIZATION_READ')";
    static final String UPDATE_ORGANIZATION = "hasAuthority('ORGANIZATION_UPDATE')";

    static final String READ_USER = "hasAuthority('USER_READ')";
    static final String UPDATE_USER = "hasAuthority('USER_UPDATE')";
}
