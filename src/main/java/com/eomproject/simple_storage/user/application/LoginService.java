package com.eomproject.simple_storage.user.application;

import com.eomproject.simple_storage.common.auth.domain.LoginSessionKeyProvider;
import com.eomproject.simple_storage.user.application.dto.LoginSessionKey;
import com.eomproject.simple_storage.user.application.port.in.LoginUseCase;
import com.eomproject.simple_storage.user.application.port.out.FindUserPort;
import com.eomproject.simple_storage.common.auth.application.out.SaveUserSessionPort;
import com.eomproject.simple_storage.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements LoginUseCase {

    private final FindUserPort findUserPort;
    private final PasswordManager passwordManager;
    private final SaveUserSessionPort saveUserSessionPort;

    @Override
    public LoginSessionKey login(String account, String password) {
        User user = findUserPort.findByAccount(account);
        validatePassword(password, user);
        String loginSessionKey = createSessionKey(user);
        return new LoginSessionKey(loginSessionKey);
    }

    private void validatePassword(String password, User user) {
        if (!passwordManager.validateLogin(password, user.getPassword())) {
            throw new RuntimeException("Login password is valid.");
        }
    }

    private String createSessionKey(User user) {
        String loginSessionKey = LoginSessionKeyProvider.createLoginSessionKey();
        saveUserSessionPort.saveSessionKey(user.getAccount(), loginSessionKey);
        return loginSessionKey;
    }
}
