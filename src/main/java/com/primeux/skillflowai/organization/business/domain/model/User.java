package com.primeux.skillflowai.organization.business.domain.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
public class User {

    private UserId id;
    private String tenantId;
    private Email email;
    private Password password;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Status status;
    private OrganizationId organizationId;
    private final Set<Role> roles = new HashSet<>();

    public void addRoles(Role... roles) {
        getRoles().addAll(List.of(roles));
    }

    public boolean isActive() {
        return hasStatus(Status.ACTIVE);
    }

    public boolean isInactive() {
        return hasStatus(Status.INACTIVE);
    }

    private boolean hasStatus(Status status) {
        return this.status == status;
    }

    public static User create(String firstName, String lastName, Email email, Password password, Role role) {
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);

        User user = new User();
        user.setId(new UserId());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setStatus(Status.INACTIVE);
        user.addRoles(role);
        return user;
    }

}
