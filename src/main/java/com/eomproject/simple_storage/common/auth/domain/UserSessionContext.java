package com.eomproject.simple_storage.common.auth.domain;

public class UserSessionContext {

    private static final ThreadLocal<Long> USER_SESSION_CONTEXT = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        USER_SESSION_CONTEXT.set(userId);
    }

    public static Long getUserId() {
        return USER_SESSION_CONTEXT.get();
    }

    public static void clear() {
        USER_SESSION_CONTEXT.remove();
    }
}

