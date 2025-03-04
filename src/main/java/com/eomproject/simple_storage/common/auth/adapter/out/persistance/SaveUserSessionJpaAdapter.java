package com.eomproject.simple_storage.common.auth.adapter.out.persistance;

import com.eomproject.simple_storage.common.auth.adapter.out.persistance.jpa.UserSessionRepository;
import com.eomproject.simple_storage.common.auth.application.out.SaveUserSessionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SaveUserSessionJpaAdapter implements SaveUserSessionPort {

    private final UserSessionRepository userSessionRepository;

    @Override
    public void saveSessionKey(String account, String loginSessionKey) {
        // userSessionRepository.save()
    }
}
