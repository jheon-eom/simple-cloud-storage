package com.eomproject.simple_storage.user.adapter.in.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserRequestTest {

    @Test
    void RegisterUserRequest_account_null_값이_들어올_경우_예외가_발생한다() {
        // given
        String account = null;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new RegisterUserRequest(account, "password"));

        // then
        assertEquals("account is null or empty", exception.getMessage());
    }

    @Test
    void RegisterUserRequest_password_null_값이_들어올_경우_예외가_발생한다() {
        // given
        String password = null;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new RegisterUserRequest("account", password));

        // then
        assertEquals("password is null or empty", exception.getMessage());
    }
}