package com.eomproject.simple_storage.user.adapter.out.persistance;

import com.eomproject.simple_storage.user.adapter.out.persistance.jpa.UserJpaEntity;
import com.eomproject.simple_storage.user.adapter.out.persistance.jpa.UserRepository;
import com.eomproject.simple_storage.user.application.port.out.RegisterUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RegisterUserJpaAdapter implements RegisterUserPort {

    private final UserRepository userRepository;

    @Override
    public UserJpaEntity save(UserJpaEntity userJpaEntity) {
        return userRepository.save(userJpaEntity);
    }
}
