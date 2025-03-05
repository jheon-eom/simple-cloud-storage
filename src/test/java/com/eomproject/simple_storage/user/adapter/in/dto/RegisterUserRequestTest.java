package com.eomproject.simple_storage.user.adapter.in.dto;

import com.eomproject.simple_storage.user.adapter.in.web.dto.RegisterUserRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserRequestTest {

    @Test
    void RegisterUserRequest_account_null_값이_들어올_경우_예외가_발생한다() {
        // given
        String account = null;
        String password = "abc1234";

        // when
        assertThrows(IllegalArgumentException.class, () -> new RegisterUserRequest(account, password));
    }

    @Test
    void RegisterUserRequest_password_null_값이_들어올_경우_예외가_발생한다() {
        // given
        String account = "abc123";
        String password = null;

        // when
        assertThrows(IllegalArgumentException.class, () -> new RegisterUserRequest(account, password));
    }
}