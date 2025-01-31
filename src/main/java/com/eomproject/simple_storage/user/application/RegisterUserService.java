package com.eomproject.simple_storage.user.application;

import com.eomproject.simple_storage.file.application.port.in.CreateDirectoryUseCase;
import com.eomproject.simple_storage.user.adapter.out.persistance.UserJpaEntity;
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
    public void registerUser(RegisterUserCommand command) {
        String encryptPassword = passwordManager.encryptPassword(command.password());
        User user = new User(command.account(), encryptPassword);
        UserJpaEntity userJpaEntity = toEntity(user);
        UserJpaEntity registeredUser = registerUserPort.save(userJpaEntity);
        // 사용자의 루트 디렉토리 생성
        // 메시지큐 통해서 전달하면 모듈 결합도 문제를 완화할 수 있음
        createDirectoryUseCase.createRootDirectory(registeredUser.getId());
    }

    private UserJpaEntity toEntity(User user) {
        return UserJpaEntity.builder()
                .account(user.getAccount())
                .password(user.getPassword())
                .build();
    }
}
