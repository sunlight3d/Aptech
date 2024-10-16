package com.example.de01.services.user;

import com.example.de01.models.User;

public interface UserService {
    User login(String username, String password);
}
