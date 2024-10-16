package com.aptech.de01.controllers;

import com.aptech.de01.services.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    //dependency Injection
    private final UserService userService;
    @GetMapping("/login")
    public String login(Model model) {
        // Send data to the view in Thymeleaf
        //model.addAttribute("x", "1");
        //model.addAttribute("y", "2");
        // Return the view name in Thymeleaf
        return "user/login";//detail of Thymeleaf view
    }
    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model, HttpSession session) {
        if (userService.login(username, password)) {
            // Successful login
            session.setAttribute("username", username);
            session.setAttribute("loggedIn", true);
            return "redirect:/";
        } else {
            // Failed login
            String errorMessage = "Incorrect username or password. Please try again.";
            model.addAttribute("errorMessage", errorMessage);
            return "user/login";
        }
    }
}
