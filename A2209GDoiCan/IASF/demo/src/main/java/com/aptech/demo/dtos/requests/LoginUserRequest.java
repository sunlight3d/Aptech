package com.aptech.demo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Builder //custom constructor

public class LoginUserRequest {
    private String username;
    private String email;
    private String password;
}
