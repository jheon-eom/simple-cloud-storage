package com.eomproject.simple_storage.user.application.port.in;

import com.eomproject.simple_storage.user.adapter.in.dto.RegisterUserRequest;
import com.eomproject.simple_storage.user.application.dto.RegisterUserCommand;

public interface RegisterUserUseCase {

    void registerUser(RegisterUserCommand command);
}
