package com.eomproject.simple_storage.user.application.port.out;

import com.eomproject.simple_storage.user.domain.User;

public interface FindUserPort {

    boolean existsUserByAccount(String account);

    User findByAccount(String account);
}
