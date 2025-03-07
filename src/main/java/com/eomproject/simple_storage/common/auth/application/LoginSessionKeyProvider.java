package com.eomproject.simple_storage.common.auth.application;

import java.util.UUID;

public class LoginSessionKeyProvider {

    public static String createLoginSessionKey() {
        return UUID.randomUUID().toString();
    }
}
