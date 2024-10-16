package com.example.de01.controllers;

import com.example.de01.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.de01.models.*;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "user/login";//where is path: resources/???
    }
    //sau khi bam login=
    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            return "redirect:/home";  // Redirect to the home page after successful login
        } else {
            model.addAttribute("errorMessage",
                    "Please enter correct username and password to login");
            return "user/login";  // Return to the login page with an error message
        }
    }
}
