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
@RequestMapping("")
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/users/login";
        }
        return "home";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();
        // Redirect to the login page or any other desired page
        return "redirect:/users/login";
    }
}
