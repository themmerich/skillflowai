package com.primeux.skillflowai.organization.presentation.controller;

import com.primeux.skillflowai.organization.business.domain.model.UserId;
import com.primeux.skillflowai.organization.business.ports.in.usecases.ReadUserUseCase;
import com.primeux.skillflowai.organization.business.ports.in.usecases.UpdateUserUseCase;
import com.primeux.skillflowai.organization.presentation.mapper.UserResourcesMapper;
import com.primeux.skillflowai.organization.presentation.resources.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.primeux.skillflowai.organization.presentation.controller.OrganizationAuthorities.READ_USER;
import static com.primeux.skillflowai.organization.presentation.controller.OrganizationAuthorities.UPDATE_USER;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserResourcesMapper userMapper;
    private final ReadUserUseCase readUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @GetMapping
    @ResponseBody
    @PreAuthorize(READ_USER)
    public List<UserReadDto> readAll() {
        return readUserUseCase.readAll().stream().map(userMapper::toReadDto).toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @PreAuthorize(READ_USER)
    public UserReadDto read(@PathVariable String id) {
        return readUserUseCase.read(UserId.fromString(id)).map(userMapper::toReadDto).orElseThrow(() -> new RuntimeException("User not found for id " + id));
    }

    @PutMapping
    @ResponseBody
    @PreAuthorize(UPDATE_USER)
    public void update(@RequestBody UpdateUserUseCase.UpdateUserCommand command) {
        updateUserUseCase.update(command);
    }
}
