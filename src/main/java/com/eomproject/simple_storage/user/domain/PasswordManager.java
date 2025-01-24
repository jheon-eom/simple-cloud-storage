package com.eomproject.simple_storage.user.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PasswordManager {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String encryptPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
