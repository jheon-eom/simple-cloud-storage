package com.eomproject.simple_storage.user.application.port.out;

import com.eomproject.simple_storage.user.adapter.out.persistance.jpa.UserJpaEntity;

public interface RegisterUserPort {


    UserJpaEntity save(UserJpaEntity userJpaEntity);
}
