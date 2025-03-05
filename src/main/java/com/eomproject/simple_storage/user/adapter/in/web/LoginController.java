package com.eomproject.simple_storage.user.adapter.in.web;

import com.eomproject.simple_storage.user.adapter.in.web.dto.LoginRequest;
import com.eomproject.simple_storage.user.application.dto.LoginSessionKey;
import com.eomproject.simple_storage.user.application.port.in.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class LoginController {

    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    public ResponseEntity<LoginSessionKey> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(loginUseCase.login(loginRequest.account(), loginRequest.password()));
    }
}
