package com.eomproject.simple_storage.user.application.dto;

public record RegisterUserCommand(
        String account,
        String password
) {
    public RegisterUserCommand {
        if (account.length() < 5) {
            throw new IllegalArgumentException("account is too short");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("password is too short");
        }
    }
}
