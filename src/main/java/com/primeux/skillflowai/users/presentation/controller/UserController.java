package com.primeux.skillflowai.users.presentation.controller;

import com.primeux.skillflowai.users.business.domain.model.UserId;
import com.primeux.skillflowai.users.business.ports.usecases.ReadUserUseCase;
import com.primeux.skillflowai.users.presentation.mapper.UserResourcesMapper;
import com.primeux.skillflowai.users.presentation.resources.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserResourcesMapper userMapper;
    private final ReadUserUseCase readUserUseCase;

    @GetMapping
    @ResponseBody
    @PreAuthorize("hasAuthority('USER_READ')")
    public List<UserReadDto> readAll() {
        return readUserUseCase.readAll().stream().map(userMapper::toReadDto).toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('USER_READ')")
    public UserReadDto read(@PathVariable String id) {
        return readUserUseCase.read(UserId.of(id)).map(userMapper::toReadDto).orElseThrow(() -> new RuntimeException("User not found for id " + id));
    }
}
