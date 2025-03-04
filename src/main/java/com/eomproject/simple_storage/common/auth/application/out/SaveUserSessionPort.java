package com.eomproject.simple_storage.common.auth.application.out;

public interface SaveUserSessionPort {

    void saveSessionKey(String account, String loginSessionKey);
}
