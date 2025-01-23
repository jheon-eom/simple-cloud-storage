package com.eomproject.simple_storage.user.application;

import com.eomproject.simple_storage.user.adapter.out.UserJpaEntity;
import com.eomproject.simple_storage.user.application.dto.RegisterUserCommand;
import com.eomproject.simple_storage.user.application.port.in.RegisterUserUseCase;
import com.eomproject.simple_storage.user.application.port.out.RegisterUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final RegisterUserPort registerUserPort;

    @Override
    public void registerUser(RegisterUserCommand command) {
        /**
         * 1. 패스워드 암호화
         * 1. command를 User 도메인으로 변환
         * 2. User 도메인을 엔티티로 변환
         * 3. 엔티티를 저장
         */
        registerUserPort.saveUser();
    }
}
