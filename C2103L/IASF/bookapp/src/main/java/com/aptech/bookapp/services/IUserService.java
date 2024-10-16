package com.aptech.bookapp.services;

import com.aptech.bookapp.models.User;
import com.aptech.bookapp.viewmodels.UserRegisterModel;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User login(String username, String password);
    User register(UserRegisterModel model);
}
