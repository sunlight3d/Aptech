package com.aptech.demo.dtos.requests;

import jakarta.persistence.Column;
import lombok.*;
import java.time.LocalDate;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder //custom constructor

public class RegisterUserRequest {
    private String username;
    private String email;
    private String password;
    private String retypePassword;
    private String role;
}
