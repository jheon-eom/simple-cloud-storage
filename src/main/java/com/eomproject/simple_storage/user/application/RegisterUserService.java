package com.eomproject.simple_storage.user.application;

import com.eomproject.simple_storage.user.adapter.out.UserJpaEntity;
import com.eomproject.simple_storage.user.application.dto.RegisterUserCommand;
import com.eomproject.simple_storage.user.application.port.in.RegisterUserUseCase;
import com.eomproject.simple_storage.user.application.port.out.RegisterUserPort;
import com.eomproject.simple_storage.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final PasswordManager passwordManager;
    private final RegisterUserPort registerUserPort;

    @Override
    public void registerUser(RegisterUserCommand command) {
        String encryptPassword = passwordManager.encryptPassword(command.password());
        User user = new User(command.account(), encryptPassword);
        UserJpaEntity userJpaEntity = toEntity(user);
        registerUserPort.save(userJpaEntity);
    }

    private UserJpaEntity toEntity(User user) {
        return UserJpaEntity.builder()
                .account(user.getAccount())
                .password(user.getPassword())
                .build();
    }
}
