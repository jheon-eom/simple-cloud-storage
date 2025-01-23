package com.eomproject.simple_storage.user.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserCommandTest {

    @Test
    void account_5글자_미만일_경우_예외_발생() {
        // given
        String account = "1234";

        // when
        assertThrows(IllegalArgumentException.class, () -> new RegisterUserCommand(account, "password"));
    }

    @Test
    void password_8글자_미만일_경우_예외_발생() {
        // given
        String password = "1234";

        // when
        assertThrows(IllegalArgumentException.class, () -> new RegisterUserCommand("12345", password));
    }
}