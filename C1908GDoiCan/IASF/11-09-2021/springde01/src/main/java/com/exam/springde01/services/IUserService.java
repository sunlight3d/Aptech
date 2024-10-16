package com.exam.springde01.services;

import com.exam.springde01.models.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IUserService {
    public User login(String username, String password);
}
