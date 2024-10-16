package com.aptech.apidemo.controllers;

import com.aptech.apidemo.models.User;
import com.aptech.apidemo.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository repository; //must init
    //DI = Dependency Injection
    public UserController(UserRepository repository) {
        this.repository = repository;
    }
    //routers
    //Postman : Raw, JSON
    @PostMapping("/registerUser")
    User registerUser(@RequestBody User newUser) {
        System.out.println("aaa");
        return this.repository.save(newUser);
    }
    @GetMapping("/users")//test only
    List<User> getAllUsers() {
        return repository.findAll();
    }
    @GetMapping("/users/{id}")
    User findById(@PathVariable Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("Cannot find user"));
    }

    @PutMapping("/users/{id}") //update or insert
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setFullName(newUser.getFullName());
                    user.setPhoneNumber(newUser.getPhoneNumber());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }
    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/test") //ok
    public User test() throws Exception {
        System.out.println("aaa");
        return this.repository.findById(1L)
                .orElseThrow(() -> new Exception("haha"));
    }
}
