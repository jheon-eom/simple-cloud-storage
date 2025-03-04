package com.eomproject.simple_storage.user.adapter.out.persistance;

import com.eomproject.simple_storage.user.adapter.out.persistance.jpa.UserRepository;
import com.eomproject.simple_storage.user.application.port.out.FindUserPort;
import com.eomproject.simple_storage.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindUserJpaAdapter implements FindUserPort {

    private final UserRepository userRepository;

    @Override
    public boolean existsUserByAccount(String account) {
        return userRepository.existsByAccount(account);
    }

    @Override
    public User findByAccount(String account) {
        return userRepository.findByAccount(account);
    }
}
