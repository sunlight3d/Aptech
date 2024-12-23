package com.aptech.demo.controllers;
import com.aptech.demo.dtos.requests.InsertStudentRequest;
import com.aptech.demo.dtos.requests.RegisterUserRequest;
import com.aptech.demo.models.Student;
import com.aptech.demo.models.User;
import com.aptech.demo.repositories.StudentRepository;
import com.aptech.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aptech.demo.dtos.requests.*;
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
    //http://localhost:8082/http://localhost:8082/users/register/register
    public String register(@ModelAttribute("request") RegisterUserRequest request,  Model model) {
        //convert InsertStudentRequest to model
        User user = User.fromRequest(request);
        repository.save(user);
        // Redirect về endpoint danh sách sinh viên
        return "redirect:/students"; // Redirect đến @GetMapping("")
    }
    //login
    @GetMapping("/login")
    //http://localhost:8082/auth/register
    public String login(Model model) {
        model.addAttribute("request", new LoginUserRequest());
        return "users/login";
    }
    @PostMapping("/login")
    //http://localhost:8082/http://localhost:8082/users/register/register
    public String login(@ModelAttribute("request") LoginUserRequest request,  Model model) {
        //Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        User existingUser = repository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        if (existingUser.getPassword().equals(request.getPassword())) {
            //not recommended !!
            throw new RuntimeException("Wrong email/password");
        }
        model.addAttribute("user", existingUser);
        return "redirect:/students";
    }
}
