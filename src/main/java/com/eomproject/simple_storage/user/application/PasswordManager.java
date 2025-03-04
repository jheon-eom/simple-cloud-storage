package com.eomproject.simple_storage.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PasswordManager { // 책임이 명확해지면 Manager 대신 책임과 관련된 이름으로 변경

    private final PasswordEncoder passwordEncoder;

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean validateLogin(String loginInputPassword, String savedPassword) {
        return passwordEncoder.matches(loginInputPassword, savedPassword);
    }
}
