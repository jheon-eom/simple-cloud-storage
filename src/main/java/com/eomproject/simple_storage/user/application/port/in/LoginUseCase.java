package com.eomproject.simple_storage.user.application.port.in;

import com.eomproject.simple_storage.user.application.dto.LoginSessionKey;

public interface LoginUseCase {

    LoginSessionKey login(String account, String password);
}
