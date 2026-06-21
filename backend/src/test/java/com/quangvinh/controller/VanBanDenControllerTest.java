package com.quangvinh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quangvinh.dto.request.LoginRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("VanBanDen API")
class VanBanDenControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    @Test
    @DisplayName("GET /van-ban-den returns 401 when unauthenticated")
    void getAll_unauthenticated_returns401() throws Exception {
        mockMvc.perform(get("/van-ban-den"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("POST /auth/login with invalid credentials returns 401")
    void login_invalidCredentials_returns401() throws Exception {
        LoginRequest req = new LoginRequest("wrong_user", "wrong_pass");
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("POST /auth/login with blank fields returns 400")
    void login_blankFields_returns400() throws Exception {
        LoginRequest req = new LoginRequest("", "");
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isBadRequest());
    }
}
