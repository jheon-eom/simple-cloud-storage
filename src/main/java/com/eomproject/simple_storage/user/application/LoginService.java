package com.eomproject.simple_storage.user.application;

import com.eomproject.simple_storage.user.application.port.in.LoginUseCase;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginUseCase {

    @Override
    public void login(String account, String password) {
        // account로 유저 조회
        // 파라미터로 받은 패스워드를 암호화하여 일치하는지 검사
    }
}
