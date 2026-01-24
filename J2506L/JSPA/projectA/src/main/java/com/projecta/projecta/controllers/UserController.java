package com.projecta.projecta.controllers;

import com.projecta.projecta.dtos.requests.user.UserRegisterRequest;
import com.projecta.projecta.models.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("register")
    //POST http://localhost:8086/users/register
    public User register(@Valid @RequestBody UserRegisterRequest request) {
        //convert/mapping DTO to model
        /*
        User newUser = User.builder()
                .email(request.getEmail())
                .fullName(request.getFullName())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .build();

         */
        User newUser = User.fromDTO(request);
        //final User user2 = newUser;
        //user2.setPassword("x232323"); //ok
        //user2 = new User(); //NO because user2 is "final"

        return newUser;
    }
}
