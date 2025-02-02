package com.primeux.skillflowai.users.infrastructure.security;

import com.primeux.skillflowai.users.core.domain.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

class SkillflowUserDetails implements UserDetails {
    private final User user;

    public SkillflowUserDetails(User user) {
        Objects.requireNonNull(user);
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(permission -> new SimpleGrantedAuthority(permission.getCode()))
                .toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword().password();
    }

    @Override
    public String getUsername() {
        return user.getEmail().email();
    }
}
