package com.aptech.de12.controllers;
import com.aptech.de12.models.Book;
import com.aptech.de12.models.User;
import com.aptech.de12.repositories.BookRepository;
import com.aptech.de12.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    // Show login form
    @GetMapping("/login")
    public String login(@ModelAttribute User user) {
        return "user/login";  // Return the view with the login form
    }

    // Process login
    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        boolean isAuthenticated = userRepository.findByEmailAndPassword(email, password).isPresent();
        if (isAuthenticated) {
            return "redirect:/books";// Redirect to dashboard or another page on successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "user/login";  // Return the login view with an error message
        }
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/register";  // Return the registration view
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("retypePassword") String retypePassword,
            Model model) {

        // Check if the passwords match
        if (!password.equals(retypePassword)) {
            model.addAttribute("errorMessage", "Passwords do not match");
            return "user/register"; // Return to the registration page with an error message
        }
        User newUser = User.builder()
                .email(email)
                .password(password)
                .build();
        userRepository.save(newUser);
        return "redirect:/users/login"; // Redirect to login page after successful registration
    }
}
