package com.usermanagement.services;

import com.usermanagement.dtos.requests.UserUpdateRequest;
import com.usermanagement.models.User;
import com.usermanagement.respositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    public List<User> findAll() {
        return repository.findAll();
    }
    private final PasswordEncoder encoder; // Spring sẽ tự động tiêm Bean vào đây

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(Long id, UserUpdateRequest req) {
        User existingUser = findById(id);

        if (req.getRole() != null) {
            existingUser.setRole(req.getRole());
        }

        if (req.getPassword() != null && !req.getPassword().isBlank()) {
            existingUser.setPassword(encoder.encode(req.getPassword()));
        }

        return repository.save(existingUser);
    }


    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
    public boolean isOwner(Long targetUserId, String currentUsername) {
        User user = repository.findById(targetUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getUsername().equals(currentUsername);
    }
    public void delete(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setDeleted(true);
        repository.save(user);
    }
}
