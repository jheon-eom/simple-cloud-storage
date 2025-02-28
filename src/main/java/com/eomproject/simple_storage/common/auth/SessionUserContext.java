package com.eomproject.simple_storage.common.auth;

public class SessionUserContext {

    private static final ThreadLocal<Long> sessionUserContext = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        sessionUserContext.set(userId);
    }

    public static Long getUserId() {
        return sessionUserContext.get();
    }

    public static void clear() {
        sessionUserContext.remove();
    }
}

