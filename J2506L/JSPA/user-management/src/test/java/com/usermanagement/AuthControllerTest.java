package com.usermanagement;

import com.usermanagement.controllers.AuthController;
import com.fasterxml.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import com.usermanagement.dtos.requests.*;
import com.usermanagement.dtos.responses.AuthResponse;
import com.usermanagement.security.JwtUtil;
import com.usermanagement.services.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(AuthController.class)
@Import(org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration.class)
@AutoConfigureMockMvc(addFilters = false)//Disable security filter trong test
@ActiveProfiles("test")
class AuthControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AuthService authService;

    @MockitoBean
    private JwtUtil jwtUtil;

//    @Autowired
//    private ObjectMapper objectMapper;

    @Autowired
    private JsonMapper jsonMapper;

    // ================= REGISTER =================

    @Test
    void register_success() throws Exception {
        // given
        AuthRequest req = new AuthRequest();
        req.setUsername("user_test_01");
        req.setPassword("password123");

        // when + then
        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(req)))
                .content(jsonMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("fake-jwt-token"))
                .andExpect(jsonPath("$.username").value("user_test_01"))
                .andExpect(jsonPath("$.role").value("ROLE_USER"));
    }

    // ================= LOGIN =================

    @Test
    void login_success() throws Exception {
        AuthRequest req = new AuthRequest();
        req.setUsername("user_test_01");
        req.setPassword("password123");


        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        //.content(objectMapper.writeValueAsString(req)))
                        .content(jsonMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value(
                        //Test đúng format JWT: xxxxx.yyyyy.zzzzz
                        org.hamcrest.Matchers.matchesPattern("^[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+$")
                ))
                .andExpect(jsonPath("$.role").value("ROLE_USER"));
    }

    // ================= VALIDATION =================

    @Test
    void register_fail_when_username_blank() throws Exception {
        AuthRequest req = new AuthRequest();
        req.setUsername("");
        req.setPassword("password123");

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        //.content(objectMapper.writeValueAsString(req)))
                        .content(jsonMapper.writeValueAsString(req)))
                .andExpect(status().isBadRequest());
    }
}
