package com.eomproject.simple_storage.user.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public class User {

    private String account;

    private String password;

    public User(String account, String password) {
        if (password.length() < 20) {
            throw new IllegalArgumentException("Password length must be at least 20 characters.");
        }
        this.account = account;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(account, user.account);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(account);
    }
}
