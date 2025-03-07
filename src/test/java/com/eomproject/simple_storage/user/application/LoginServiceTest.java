package com.eomproject.simple_storage.user.application;

import com.eomproject.simple_storage.common.auth.application.out.SaveUserSessionPort;
import com.eomproject.simple_storage.user.application.dto.LoginSessionKey;
import com.eomproject.simple_storage.user.application.port.out.FindUserPort;
import com.eomproject.simple_storage.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginServiceTest {

    private LoginService loginService;
    private FindUserPort findUserPort;
    private PasswordManager passwordManager;
    private SaveUserSessionPort saveUserSessionPort;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        findUserPort = mock(FindUserPort.class);
        passwordEncoder = new BCryptPasswordEncoder();
        passwordManager = new PasswordManager(passwordEncoder);
        saveUserSessionPort = mock(SaveUserSessionPort.class);
        loginService = new LoginService(findUserPort, passwordManager, saveUserSessionPort);
    }

    @Test
    void 로그인_성공_시_세션_키를_발급받는다() {
        // given
        String account = "testAccount";
        String password = "testPassword";
        String encodedPassword = passwordEncoder.encode(password);
        User saveUser = new User(account, encodedPassword);

        when(findUserPort.findByAccount(account)).thenReturn(saveUser);
        doNothing().when(saveUserSessionPort).saveSessionKey(anyString(), anyString());

        // when
        LoginSessionKey loginSessionKey = loginService.login(account, password);

        // then
        assertNotNull(loginSessionKey);
        verify(findUserPort, times(1)).findByAccount(account);
        verify(saveUserSessionPort, times(1)).saveSessionKey(eq(account), anyString());
    }

    @Test
    void 로그인_실패_시_세션_키를_발급하지_않는다() {
        // given
        String account = "testAccount";
        String password = "wrongPassword";
        String encodedPassword = passwordEncoder.encode("correctPassword");
        User user = new User(account, encodedPassword);

        when(findUserPort.findByAccount(account)).thenReturn(user);

        // when & then
        assertThrows(RuntimeException.class, () -> loginService.login(account, password));
        verify(findUserPort, times(1)).findByAccount(account);
        verify(saveUserSessionPort, times(0)).saveSessionKey(anyString(), anyString());
    }

}