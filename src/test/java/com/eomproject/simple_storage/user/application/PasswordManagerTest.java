package com.eomproject.simple_storage.user.application;

import com.eomproject.simple_storage.user.application.PasswordManager;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class PasswordManagerTest {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    void 패스워드_암호화_테스트() {
        // given
        PasswordManager passwordManager = new PasswordManager(passwordEncoder);
        String password = "1234";

        // when
        String encryptedPassword = passwordManager.encryptPassword(password);

        // then
        assertNotEquals(password, encryptedPassword);
    }
}