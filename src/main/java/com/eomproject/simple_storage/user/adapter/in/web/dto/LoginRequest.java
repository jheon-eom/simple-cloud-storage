package com.eomproject.simple_storage.user.adapter.in.web.dto;

public record LoginRequest(
        String account,
        String password
) {

    public LoginRequest {
        if (account == null || account.isBlank() || password == null || password.isBlank()) {
            throw new IllegalArgumentException("로그인을 위한 입력 정보가 누락되었습니다.");
        }
    }
}
