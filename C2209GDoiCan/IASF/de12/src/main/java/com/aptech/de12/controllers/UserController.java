package com.aptech.de12.controllers;
import com.aptech.de12.models.Book;
import com.aptech.de12.models.User;
import com.aptech.de12.repositories.BookRepository;
import com.aptech.de12.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/login")
    public String processLogin(
            @RequestParam String email,
            @RequestParam String password,
            Model model,
            HttpSession session) {  // Inject HttpSession to save session data

        // Check if the user exists in the database by email and password
        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, password);

        if (userOptional.isPresent()) {
            // Store user data in session on successful login
            User user = userOptional.get();
            session.setAttribute("loggedInUser", user);  // Store the user object in the session

            // Redirect to another page after login success
            return "redirect:/books";
        } else {
            // Add error message to the model in case of invalid credentials
            model.addAttribute("error", "Invalid email or password");
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
