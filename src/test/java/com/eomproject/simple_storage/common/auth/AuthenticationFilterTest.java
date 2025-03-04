package com.eomproject.simple_storage.common.auth;

import com.eomproject.simple_storage.common.auth.filter.AuthenticationFilter;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AuthenticationFilterTest {

    private AuthenticationFilter authenticationFilter;

    @BeforeEach
    void setUp() {
        authenticationFilter = new AuthenticationFilter();
    }

    @Test
    void 인증되지_않은_사용자는_예외를_발생시킨다() {
        // given
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();

        // when & then
        assertThatThrownBy(() -> authenticationFilter.doFilter(request, response, filterChain))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 인증된_사용자는_필터를_통과한다() throws ServletException, IOException {
        // given
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();

        request.setAttribute("userId", 1L);

        // when & then
        authenticationFilter.doFilter(request, response, filterChain);
    }
}