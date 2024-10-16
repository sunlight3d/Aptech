package com.exam.springde01.controllers;

import com.exam.springde01.models.User;
import com.exam.springde01.services.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("")
    String login(Model model) {
        return "login";
    }
    @PostMapping("/login")
    String postLogin(Model model) {
        User user = service.login(model.getAttribute("username").toString(), model.getAttribute("password").toString());
        if(user == null) {
            model.addAttribute("error", "Wrong username and password");
            return "login";
        }
        model.addAttribute("user", user);
        return "welcome";
    }
}
