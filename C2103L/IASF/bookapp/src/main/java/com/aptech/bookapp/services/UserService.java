package com.aptech.bookapp.services;

import com.aptech.bookapp.models.User;
import com.aptech.bookapp.repositories.UserRepository;
import com.aptech.bookapp.viewmodels.UserRegisterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService{
    //inject
    private final UserRepository userRepository;
    @Override
    public User login(String username, String password) {
        //Khởi tạo Repo => DI (Dependency Injection)
        return userRepository.findByUsernameAndPassword(username, password)
                .orElse(null);
    }

    @Override
    public User register(UserRegisterModel model) {
        //if(model.getPassword().equals(model.getRetypePassword())) => ko can
        //phai dung "model validation"
        User newUser = User.builder()
                .password(model.getPassword())
                .username(model.getUsername())
                .dateOfBirth(model.getDateOfBirth())
                .build();
        return userRepository.save(newUser);
    }
}
