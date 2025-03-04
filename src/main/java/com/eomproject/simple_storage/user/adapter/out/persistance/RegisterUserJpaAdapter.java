package com.eomproject.simple_storage.user.adapter.out.persistance;

import com.eomproject.simple_storage.user.adapter.out.persistance.jpa.UserJpaEntity;
import com.eomproject.simple_storage.user.adapter.out.persistance.jpa.UserRepository;
import com.eomproject.simple_storage.user.application.port.out.RegisterUserPort;
import com.eomproject.simple_storage.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RegisterUserJpaAdapter implements RegisterUserPort {

    private final UserRepository userRepository;

    @Override
    public Long save(User user) {
        UserJpaEntity userJpaEntity = UserJpaEntity.builder()
                .account(user.getAccount())
                .password(user.getPassword())
                .build();

        return userRepository.save(userJpaEntity).getId();
    }
}
