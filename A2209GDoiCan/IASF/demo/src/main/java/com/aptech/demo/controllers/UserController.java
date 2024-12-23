package com.aptech.demo.controllers;
import com.aptech.demo.dtos.requests.InsertStudentRequest;
import com.aptech.demo.dtos.requests.RegisterUserRequest;
import com.aptech.demo.models.Student;
import com.aptech.demo.models.User;
import com.aptech.demo.repositories.StudentRepository;
import com.aptech.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aptech.demo.dtos.requests.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    //register
    private UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    @GetMapping("/register")
    //http://localhost:8082/users/register
    public String register(Model model) {
        model.addAttribute("request", new RegisterUserRequest());
        return "users/register";
    }

    @PostMapping("/register")
    //http://localhost:8082/users/register
    public String register(@ModelAttribute("request") RegisterUserRequest request,  Model model) {
        //convert InsertStudentRequest to model
        User user = User.fromRequest(request);
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(hashedPassword);
        repository.save(user);
        // Redirect về endpoint danh sách sinh viên
        return "redirect:/students"; // Redirect đến @GetMapping("")
    }
    //login
    @GetMapping("/login")
    //http://localhost:8082/users/register
    public String login(Model model) {
        model.addAttribute("request", new LoginUserRequest());
        return "users/login";
    }
    @PostMapping("/login")
    //http://localhost:8082/users/register
    public String login(@ModelAttribute("request") LoginUserRequest request,  Model model) {
        //Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        User existingUser = repository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(request.getPassword(), existingUser.getPassword())) {
            throw new RuntimeException("Wrong email/password");
        }
        model.addAttribute("user", existingUser);
        return "redirect:/students";
    }
}
