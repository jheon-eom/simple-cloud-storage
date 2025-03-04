package com.eomproject.simple_storage.common.auth.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        if (servletRequest.getAttribute("userId") == null) {
            throw new RuntimeException("인증되지 않은 사용자입니다.");
        }
    }
}
