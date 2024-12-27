package com.aptech.demo.controllers;
import com.aptech.demo.dtos.requests.InsertStudentRequest;
import com.aptech.demo.dtos.requests.RegisterUserRequest;
import com.aptech.demo.models.Student;
import com.aptech.demo.models.User;
import com.aptech.demo.repositories.StudentRepository;
import com.aptech.demo.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aptech.demo.dtos.requests.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.security.MessageDigest;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    //register
    private UserRepository repository;
    @GetMapping("/register")
    //http://localhost:8082/auth/register
    public String register(Model model) {
        model.addAttribute("request", new RegisterUserRequest());
        return "users/register";
    }

    @PostMapping("/register")
    //http://localhost:8082/http://localhost:8082/users/register
    public String register(
            @ModelAttribute("request") @Valid RegisterUserRequest request,
            BindingResult bindingResult,
            HttpSession session,
            Model model) {
        // Nếu có lỗi validation, trả lại view với lỗi
        if (bindingResult.hasErrors()) {
            return "users/register";
        }
        //convert InsertStudentRequest to model
        User user = User.fromRequest(request);
        repository.save(user);
        // Redirect về endpoint danh sách sinh viên
        return "redirect:/students"; // Redirect đến @GetMapping("")
    }
    //login
    @GetMapping("/login")
    //http://localhost:8082/auth/register
    public String login( Model model) {
        return "users/login";
    }
    @GetMapping("/profile/{id}")
    //http://localhost:8082/auth/register
    public String profile(@PathVariable("id") Long userId, Model model) {
        User user = repository.findById(userId).get();
        EditUserRequest editUserRequest = new EditUserRequest();
        editUserRequest.setName(user.getUsername());
        editUserRequest.setEmail(user.getEmail());
        editUserRequest.setPassword(user.getPassword());
        editUserRequest.setUrl(user.getUrl());
        model.addAttribute("request", editUserRequest);
        return "users/profile";
    }
    @PostMapping("/login")
    //http://localhost:8082/http://localhost:8082/users/register/register
    public String login(
            @ModelAttribute("request") @Valid LoginUserRequest request,
            BindingResult bindingResult,
            HttpSession session,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "users/login";
        }
        //Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        User existingUser = repository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        if (!existingUser.getPassword().equals(request.getPassword())) {
            //not recommended !!
            throw new RuntimeException("Wrong email/password");
        }
        // Save user to session
        session.setAttribute("loggedInUser", existingUser);
        model.addAttribute("user", existingUser);
        return "redirect:/students";
    }
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the current session to log out the user
        session.invalidate();

        // Redirect to the login page after logout
        return "redirect:/auth/login";
    }
}
