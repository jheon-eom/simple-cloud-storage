package com.eomproject.simple_storage.user.adapter.out;

import com.eomproject.simple_storage.user.application.port.out.RegisterUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SaveUserAdapter implements RegisterUserPort {

    private final UserRepository userRepository;

    @Override
    public void save(UserJpaEntity userJpaEntity) {
        userRepository.save(userJpaEntity);
    }
}
