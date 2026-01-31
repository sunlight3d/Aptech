package com.usermanagement.services;

import com.usermanagement.dtos.responses.AuthResponse;
import com.usermanagement.exceptions.UserAlreadyExistsException;
import com.usermanagement.models.User;
import com.usermanagement.respositories.UserRepository;
import com.usermanagement.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder; // Spring sẽ tự động tiêm Bean vào đây

    public AuthResponse register(String username, String password) {
        if (userRepo.existsByUsername(username)) {
            throw new UserAlreadyExistsException("User already exists");
        }

        User newUser = User.builder()
                .username(username)
                .password(encoder.encode(password))
                .role("ROLE_USER") // Mặc định là USER
                .deleted(false)
                .build();

        userRepo.save(newUser);

        // Đăng ký xong, tự động tạo token luôn
        String token = jwtUtil.generateToken(newUser.getUsername(), newUser.getRole());
        return new AuthResponse(token, newUser.getUsername(), newUser.getRole());
    }

    public AuthResponse login(String username, String password) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
        return new AuthResponse(token, user.getUsername(), user.getRole());
    }

}
