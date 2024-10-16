package com.exam.springde01.services;

import com.exam.springde01.models.User;
import com.exam.springde01.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService implements IUserService{
    @Autowired
    private UserRepository repository;
    @Override
    public User login(String username, String password) {
        return repository.findByUsernameAndPassword(username.trim(), password);
    }
}
