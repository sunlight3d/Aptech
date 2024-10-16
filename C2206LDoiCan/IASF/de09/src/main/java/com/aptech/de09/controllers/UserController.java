package com.aptech.de09.controllers;

import com.aptech.de09.dtos.requests.LoginRequest;
import com.aptech.de09.dtos.responses.UserResponse;
import com.aptech.de09.models.User;
import com.aptech.de09.repositories.UserRepository;
import com.aptech.de09.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/login")
    public String login(Model model) {
        return "user/login";//view path
    }
    @PostMapping("/login")
    public String performLogin(@Valid LoginRequest loginRequest, BindingResult bindingResult, Model model) {
        List<ObjectError> errors = bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            //truyền string lỗi lên user/login
            model.addAttribute("errors", errors);
            return "user/login"; //display in view
        }
        //truy cap xuong db, kiem tra co user do ko,....
        /*
        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());
        if(optionalUser.isPresent()) {
            //tiep tuc kiem tra pass
            User user = optionalUser.get();

        } else {
            //ten hoac pass chua dung
        }
        */
        UserResponse userResponse = userService.login(loginRequest);
        if (userResponse == null) {
            bindingResult.reject("login.failed", "Incorrect username/password");
            return "user/login";
        }
        return "home";


    }
}
/*
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO users (username, password, email) VALUES
('johndoe', 'password123', 'john.doe@example.com'),
('janedoe', 'password456', 'jane.doe@example.com'),
('mikebrown', 'password789', 'mike.brown@example.com');

* */