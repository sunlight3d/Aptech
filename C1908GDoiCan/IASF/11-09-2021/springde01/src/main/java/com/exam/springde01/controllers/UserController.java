package com.exam.springde01.controllers;

import com.exam.springde01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("")
    String login(Model model) {
        return "login";
    }
}
