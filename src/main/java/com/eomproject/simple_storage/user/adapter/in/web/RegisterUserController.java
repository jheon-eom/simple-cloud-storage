package com.eomproject.simple_storage.user.adapter.in.web;

import com.eomproject.simple_storage.user.adapter.in.dto.RegisterUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RestController
public class RegisterUserController {

    @PostMapping
    public void registerUser(@RequestBody RegisterUserRequest registerUserRequest) {

    }
}
