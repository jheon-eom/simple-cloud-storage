package com.eomproject.simple_storage.common.auth;

import jakarta.servlet.*;

import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        if (servletRequest.getAttribute("userId") == null) {
            throw new ServletException("Unauthorized access");
        }
    }
}
