package com.primeux.skillflowai.users.application.rest;

import com.primeux.skillflowai.security.domain.model.DenyAccess;
import com.primeux.skillflowai.users.application.dto.UserReadDto;
import com.primeux.skillflowai.users.domain.model.User;
import com.primeux.skillflowai.users.domain.model.UserId;
import com.primeux.skillflowai.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@DenyAccess
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    @ResponseBody
    //@PreAuthorize("hasAuthority('USER_READ')")
    public UserReadDto read(@PathVariable String id) {
        return userRepository.findById(new UserId(UUID.fromString(id))).map(this::toReadDto).orElseThrow();
    }

    //TODO: Mapstruct verwenden
    private UserReadDto toReadDto(User user) {
        UserReadDto readDto = new UserReadDto();
        readDto.setFirstName(user.getFirstName());
        readDto.setLastName(user.getLastName());
        readDto.setEmail(user.getEmail().email());
        return readDto;
    }
}
