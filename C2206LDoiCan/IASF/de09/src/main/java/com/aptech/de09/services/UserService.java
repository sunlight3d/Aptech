package com.aptech.de09.services;

import com.aptech.de09.dtos.requests.LoginRequest;
import com.aptech.de09.dtos.responses.UserResponse;
import com.aptech.de09.models.User;
import org.springframework.stereotype.Service;


public interface UserService {
    UserResponse login(LoginRequest loginRequest);
}
