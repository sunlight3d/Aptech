package com.aptech.de01.controllers;
import com.aptech.de01.models.User;
import com.aptech.de01.repositories.UserRepository;
import com.aptech.de01.viewmodels.user.LoginViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    @GetMapping("/users/login")
    public String login(Model model) {
        model.addAttribute("loginViewModel", new LoginViewModel());
        return "user/login";//view's name
    }
    @PostMapping("/users/login")
    public String signin(
            @ModelAttribute("loginViewModel") LoginViewModel loginViewModel,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "/users/login";
        }
        //business
        Optional<User> optionalUser = this.userRepository.findByUsernameAndPassword(
                loginViewModel.getUsername(),
                loginViewModel.getPassword());
        if(optionalUser.isPresent()) {
            return "redirect:/books";
        }
        return "user/login";//view's name
    }

}
