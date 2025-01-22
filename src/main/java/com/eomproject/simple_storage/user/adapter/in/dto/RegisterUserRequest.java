package com.eomproject.simple_storage.user.adapter.in.dto;

public record RegisterUserRequest(
        String account,
        String password
) {
    public RegisterUserRequest {
        if (account == null || account.isBlank()) {
            throw new IllegalArgumentException("account is null or empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("password is null or empty");
        }
    }
}
