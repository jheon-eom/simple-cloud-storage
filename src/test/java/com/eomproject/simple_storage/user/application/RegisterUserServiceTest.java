package com.eomproject.simple_storage.user.application;

import com.eomproject.simple_storage.directory.application.CreateDirectoryService;
import com.eomproject.simple_storage.directory.application.port.in.CreateDirectoryUseCase;
import com.eomproject.simple_storage.directory.application.port.out.CreateDirectoryPort;
import com.eomproject.simple_storage.directory.application.port.out.SaveDirectoryPort;
import com.eomproject.simple_storage.file.mock.MockDirectoryNameProvider;
import com.eomproject.simple_storage.user.application.dto.RegisterUserCommand;
import com.eomproject.simple_storage.user.application.port.out.FindUserByAccountPort;
import com.eomproject.simple_storage.user.application.port.out.RegisterUserPort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ActiveProfiles("test")
@SpringBootTest
class RegisterUserServiceTest {

    @Autowired
    PasswordManager passwordManager;
    @Autowired
    RegisterUserPort registerUserPort;
    @Autowired
    CreateDirectoryPort createDirectoryPort;
    @Autowired
    SaveDirectoryPort saveDirectoryPort;
    @Autowired
    FindUserByAccountPort findUserByAccountPort;

    MockDirectoryNameProvider mockDirectoryNameProvider = new MockDirectoryNameProvider();

    @Test
    void 회원가입이_성공하면_유저_데이터와_루트_디렉토리_메타데이터가_디비에_저장되고_루트_디렉토리가_생성된다() throws IOException {
        // given
        RegisterUserService registerUserService = dependenciesInject1();
        RegisterUserCommand command = new RegisterUserCommand("test1234", "test12345");

        // when
        long userId = registerUserService.registerUser(command);
        String createdDirectory = mockDirectoryNameProvider.extractDirectoryNameWith(userId);

        // then
        assertEquals(1, userId);
        assertNotNull(Files.getFileStore(Path.of(createdDirectory)));
    }

    @Test
    void 회원가입_시_디렉토리_생성에_실패하면_회원가입도_실패한다() {
        // TODO: 테스트 해결이 안 됐음 !!!!!!!!!!!!
        // given
        RegisterUserService registerUserService = dependenciesInject2();
        RegisterUserCommand command = new RegisterUserCommand("test1234", "test12345");

        // when & // then
        assertThrows(RuntimeException.class, () -> registerUserService.registerUser(command));
        assertFalse(findUserByAccountPort.existsUserByAccount("test1234"));
    }

    private RegisterUserService dependenciesInject1() {
        CreateDirectoryUseCase testCreateDirectoryUseCase =
                new CreateDirectoryService(mockDirectoryNameProvider, createDirectoryPort, saveDirectoryPort);

        RegisterUserService registerUserService =
                new RegisterUserService(passwordManager, registerUserPort, testCreateDirectoryUseCase);
        return registerUserService;
    }

    private RegisterUserService dependenciesInject2() {
        CreateDirectoryPort testCreateDirectoryPort = path -> {
            throw new RuntimeException();
        };

        CreateDirectoryUseCase testCreateDirectoryUseCase =
                new CreateDirectoryService(mockDirectoryNameProvider, testCreateDirectoryPort, saveDirectoryPort);

        RegisterUserService registerUserService =
                new RegisterUserService(passwordManager, registerUserPort, testCreateDirectoryUseCase);
        return registerUserService;
    }
}