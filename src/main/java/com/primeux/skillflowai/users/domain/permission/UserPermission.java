package com.primeux.skillflowai.users.domain.permission;

public interface UserPermission {
    static final String USER_READ = "hasAuthority(USER_READ)";
    static final String USER_CREATE = "USER_CREATE";
    static final String USER_UPDATE = "USER_UPDATE";
    static final String USER_DELETE = "USER_DELETE";
}
