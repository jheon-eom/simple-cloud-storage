package com.eomproject.simple_storage.common.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AuthenticationFilterTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void 화이트_리스트가_아닌_경우_인증_헤더를_검사하여_헤더가_없을_경우_예외가_발생한다() throws Exception {
        // given
        mockMvc.perform(get("/api/v1/some-api")).andExpect(status().isUnauthorized());
        System.out.println();
    }
}