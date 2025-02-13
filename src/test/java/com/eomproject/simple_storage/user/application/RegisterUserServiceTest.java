package com.eomproject.simple_storage.user.application;

import com.eomproject.simple_storage.file.application.CreateDirectoryService;
import com.eomproject.simple_storage.file.application.port.in.CreateDirectoryUseCase;
import com.eomproject.simple_storage.file.application.port.out.CreateDirectoryPort;
import com.eomproject.simple_storage.file.application.port.out.SaveDirectoryPort;
import com.eomproject.simple_storage.file.mock.TestFilenameProvider;
import com.eomproject.simple_storage.user.application.dto.RegisterUserCommand;
import com.eomproject.simple_storage.user.application.port.out.RegisterUserPort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ActiveProfiles("test")
@SpringBootTest
class RegisterUserServiceTest {

    // DI
    @Autowired
    PasswordManager passwordManager;
    @Autowired
    RegisterUserPort registerUserPort;
    @Autowired
    CreateDirectoryPort createDirectoryPort;
    @Autowired
    SaveDirectoryPort saveDirectoryPort;

    // Mock
    TestFilenameProvider testFilenameProvider = new TestFilenameProvider();

    @Test
    void 회원가입이_성공하면_유저_데이터와_루트_디렉토리_메타데이터가_디비에_저장되고_루트_디렉토리가_생성된다() {
        // given
        CreateDirectoryUseCase testCreateDirectoryUseCase =
                new CreateDirectoryService(testFilenameProvider, createDirectoryPort, saveDirectoryPort);

        RegisterUserService registerUserService =
                new RegisterUserService(passwordManager, registerUserPort, testCreateDirectoryUseCase);
        RegisterUserCommand command = new RegisterUserCommand("test1234", "test12345");

        // when
        long userId = registerUserService.registerUser(command);

        // then
        assertEquals(1, userId);
    }
}