package com.aptech.de01.controllers;

import com.aptech.de01.models.User;
import com.aptech.de01.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {
    private final UserRepository userRepository;
    @GetMapping("/login")
    public String login(Model model) {
        return "users/login";
    }
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {
        User user = userRepository.findByUsernameAndPassword(username, password)
                .orElse(null);
        if(user != null) {
            session.setAttribute("username", username);
            return "redirect:/books/index";//later
        } else {
            return "redirect:users/login";//later
        }
    }

}
