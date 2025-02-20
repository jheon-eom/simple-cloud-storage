package com.eomproject.simple_storage.user.application.port.out;

public interface FindUserByAccountPort {

    boolean existsUserByAccount(String account);
}
