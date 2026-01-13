package com.aptech.projectA.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //http://legion-laptop:8080/hello
    @GetMapping("/hello")
    public String hello() {
        return "chao bannnnnn";//response to client
    }
}
