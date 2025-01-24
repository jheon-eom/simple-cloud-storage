package com.eomproject.simple_storage.common.auth;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        if (servletRequest.getAttribute("userId") == null) {
            throw new AuthenticationException("인증되지 않은 사용자입니다.");
        }
    }
}
