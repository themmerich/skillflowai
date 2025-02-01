package com.primeux.skillflowai.users.presentation.rest;

import com.primeux.skillflowai.users.domain.model.UserId;
import com.primeux.skillflowai.users.domain.permission.UserPermission;
import com.primeux.skillflowai.users.domain.repository.UserRepository;
import com.primeux.skillflowai.users.infrastructure.mapper.UserMapper;
import com.primeux.skillflowai.users.presentation.dto.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@PreAuthorize("denyAll()")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userDtoMapper;

    @GetMapping("/{id}")
    @ResponseBody
    @PreAuthorize(UserPermission.USER_READ)
    public UserReadDto read(@PathVariable String id) {
        return userRepository.findById(new UserId(UUID.fromString(id))).map(userDtoMapper::toReadDto).orElseThrow();
    }
}
