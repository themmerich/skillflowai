package com.primeux.skillflowai.shared.security;

import com.primeux.skillflowai.organization.business.domain.model.Permission;
import com.primeux.skillflowai.organization.business.domain.model.Role;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Roles {

    private static final Map<String, Role> roleMap = new HashMap<>();

    public static final Role ADMIN = createAdmin();
    public static final Role INSTRUCTOR = createInstructor();
    public static final Role STUDENT = createStudent();

    static {
        roleMap.put("ADMIN", ADMIN);
        roleMap.put("INSTRUCTOR", INSTRUCTOR);
        roleMap.put("STUDENT", STUDENT);
    }

    public static Role getRole(String roleName) {
        return roleMap.get(roleName);
    }

    private static Role createAdmin() {
        Role adminRole = new Role("Admin");
        adminRole.getPermissions().addAll(createPermissions(Permissions.USER.values()));
        adminRole.getPermissions().addAll(createPermissions(Permissions.ORGANIZATION.values()));
        adminRole.getPermissions().addAll(createPermissions(Permissions.COURSE.values()));
        adminRole.getPermissions().addAll(createPermissions(Permissions.QUIZ.values()));
        return adminRole;
    }

    private static Role createInstructor() {
        Role instructorRole = new Role("Instructor");
        instructorRole.addPermissions(createPermissions(Permissions.USER.READ));
        return instructorRole;
    }

    private static Role createStudent() {
        Role studentRole = new Role("Student");
        studentRole.addPermissions(createPermissions(Permissions.USER.READ));
        return studentRole;
    }

    private static Set<Permission> createPermissions(Enum<?>... permissions) {
        Set<Permission> result = new HashSet<>();
        for (Enum<?> permEnum : permissions) {
            result.add(new Permission(Permissions.getCode(permEnum)));
        }

        return result;
    }
}
