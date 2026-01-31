package com.usermanagement.controllers;

import com.usermanagement.dtos.requests.AuthRequest;
import com.usermanagement.dtos.responses.AuthResponse;
import com.usermanagement.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    @PostMapping("/register")

    public ResponseEntity<AuthResponse> register(@Valid @RequestBody AuthRequest req) {
        return ResponseEntity.ok(service.register(req.getUsername(), req.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest req) {
        return ResponseEntity.ok(service.login(req.getUsername(), req.getPassword()));
    }
}
/*
BASE_URL="http://localhost:7081"
curl -i -X POST "$BASE_URL/api/auth/register" \
  -H "Content-Type: application/json" \
  -d '{
        "username": "user_test_01",
        "password": "password123"
      }'

curl -i -X POST "$BASE_URL/api/auth/login" \
  -H "Content-Type: application/json" \
  -d '{
        "username": "user_test_01",
        "password": "password123"
      }'

# ===== base url =====
BASE_URL="http://localhost:7081"

Example response:
{
"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyX3Rlc3RfMDEiLCJyb2xlIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzY5MjQ3MjI0LCJleHAiOjE3NzE4MzkyMjR9.PXOcpN88KvZRuUYF_CVhxHvwcnDsLBzqd8Am5xua6JE",
"username":"user_test_01",
"role":"ROLE_USER"
}


* */