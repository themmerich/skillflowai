package com.primeux.skillflowai.users.presentation.controller;

import com.primeux.skillflowai.users.UserPermission;
import com.primeux.skillflowai.users.core.domain.model.UserId;
import com.primeux.skillflowai.users.core.ports.usecases.UserManagement;
import com.primeux.skillflowai.users.presentation.mapper.UserResourcesMapper;
import com.primeux.skillflowai.users.presentation.resources.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserResourcesMapper userMapper;
    private final UserManagement userManagement;

    @GetMapping("/{id}")
    @ResponseBody
    @PreAuthorize(UserPermission.USER_READ)
    public UserReadDto read(@PathVariable String id) {
        return userManagement.read(UserId.of(id)).map(userMapper::toReadDto).orElseThrow(() -> new RuntimeException("User not found for id " + id));
    }
}
