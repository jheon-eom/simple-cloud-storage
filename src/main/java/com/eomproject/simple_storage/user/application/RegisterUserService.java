package com.eomproject.simple_storage.user.application;

import com.eomproject.simple_storage.directory.application.port.in.CreateDirectoryUseCase;
import com.eomproject.simple_storage.user.adapter.out.persistance.jpa.UserJpaEntity;
import com.eomproject.simple_storage.user.application.dto.RegisterUserCommand;
import com.eomproject.simple_storage.user.application.port.in.RegisterUserUseCase;
import com.eomproject.simple_storage.user.application.port.out.RegisterUserPort;
import com.eomproject.simple_storage.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final PasswordManager passwordManager;
    private final RegisterUserPort registerUserPort;
    private final CreateDirectoryUseCase createDirectoryUseCase;

    @Transactional
    @Override
    public long registerUser(RegisterUserCommand command) {
        String encryptPassword = passwordManager.encryptPassword(command.password());
        User user = new User(command.account(), encryptPassword);

        Long registeredUserId = registerUserPort.save(user);

        createDirectoryUseCase.createRootDirectory(registeredUser.getId());

        return registeredUserId;
    }
}
