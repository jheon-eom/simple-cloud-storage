package com.eomproject.simple_storage.user.adapter.in.web;

import com.eomproject.simple_storage.user.adapter.in.dto.RegisterUserRequest;
import com.eomproject.simple_storage.user.application.port.in.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
public class RegisterUserController {

    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        registerUserUseCase.registerUser(registerUserRequest.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
