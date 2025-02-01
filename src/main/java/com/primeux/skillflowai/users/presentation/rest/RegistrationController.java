package com.primeux.skillflowai.users.presentation.rest;

import com.primeux.skillflowai.users.domain.model.User;
import com.primeux.skillflowai.users.domain.registration.RegisterUser;
import com.primeux.skillflowai.users.domain.registration.RegisterUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegisterUser registerUser;

    @PostMapping("/register")
    @ResponseBody
    public User registerUser(@RequestBody RegisterUserRequest request) {
        return registerUser.register(request);
    }
}
