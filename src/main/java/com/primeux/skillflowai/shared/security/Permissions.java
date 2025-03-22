package com.primeux.skillflowai.shared.security;

public interface Permissions {

    static String getCode(Enum<?> permissionEnum) {
        return String.format("%s_%s", permissionEnum.getDeclaringClass().getSimpleName(), permissionEnum.name());
    }

    enum USER {
        READ, CREATE, UPDATE, DELETE;
    }

    enum ORGANIZATION {
        READ, CREATE, UPDATE, DELETE
    }

    enum COURSE {
        READ, CREATE, UPDATE, DELETE
    }

    enum QUIZ {
        READ, CREATE, UPDATE, DELETE
    }
}
