package com.eomproject.simple_storage.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void User_생성_시_비밀번호_길이가_20자_미만이면_예외가_발생한다() {
        // given
        String account = "test";
        String password = "123456789";

        // when
        assertThrows(IllegalArgumentException.class, () -> new User(account, password));
    }
}