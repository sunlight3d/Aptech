package com.aptech.demo.dtos.requests;

import jakarta.persistence.Column;
import lombok.*;
import java.time.LocalDate;

import java.util.Date;
import jakarta.validation.constraints.*;
@NoArgsConstructor
@AllArgsConstructor
@Builder //custom constructor

public class RegisterUserRequest {

    @NotBlank(message = "Username is required.")
    private String username;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email format.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 4, message = "Password must be at least 4 characters long.")
    private String password;

    @NotBlank(message = "Retype password is required.")
    private String retypePassword;

    private String role;

    // Custom validation method for matching passwords
    public boolean isPasswordsMatching() {
        return password != null && password.equals(retypePassword);
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}