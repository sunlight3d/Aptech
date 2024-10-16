package com.aptech.de09.services;

import com.aptech.de09.dtos.requests.LoginRequest;
import com.aptech.de09.dtos.responses.UserResponse;
import com.aptech.de09.models.User;
import com.aptech.de09.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService{
    final UserRepository userRepository;
    @Override
    public UserResponse login(LoginRequest loginRequest) {
        return userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword())
                .map(UserResponse::fromUser)
                .orElse(null);
    }
}
