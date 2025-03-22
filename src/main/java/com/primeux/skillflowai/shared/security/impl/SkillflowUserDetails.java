package com.primeux.skillflowai.shared.security.impl;

import com.primeux.skillflowai.organization.business.domain.model.Role;
import com.primeux.skillflowai.shared.security.Roles;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
class SkillflowUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final String tenantId;
    private final Set<GrantedAuthority> authorities = new HashSet<>();

    SkillflowUserDetails(String username, String password, String tenantId, Collection<String> roles) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        Objects.requireNonNull(tenantId);
        this.username = username;
        this.password = password;
        this.tenantId = tenantId;
        if (roles != null) {
            roles.forEach(roleName -> {
                Role role = Roles.getRole(roleName);
                authorities.addAll(role.getPermissions().stream().map(p -> new SimpleGrantedAuthority(p.getCode())).collect(Collectors.toSet()));
            });
        }
    }
}
