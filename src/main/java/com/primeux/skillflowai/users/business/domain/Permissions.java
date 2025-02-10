package com.primeux.skillflowai.users.business.domain;

public interface Permissions {

    static String getCode(Enum<?> permissionEnum) {
        return String.format("%s_%s", permissionEnum.getDeclaringClass().getSimpleName(), permissionEnum.name());
    }

    static enum USER {
        READ,
        CREATE,
        UPDATE,
        DELETE;

    }
}
