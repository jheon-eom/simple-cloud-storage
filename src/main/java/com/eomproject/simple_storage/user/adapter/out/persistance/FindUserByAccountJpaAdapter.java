package com.eomproject.simple_storage.user.adapter.out.persistance;

import com.eomproject.simple_storage.user.adapter.out.persistance.jpa.UserRepository;
import com.eomproject.simple_storage.user.application.port.out.FindUserByAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindUserByAccountJpaAdapter implements FindUserByAccountPort {

    private final UserRepository userRepository;

    @Override
    public boolean existsUserByAccount(String account) {
        return userRepository.existsByAccount(account);
    }
}
