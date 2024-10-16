package com.aptech.de12.repositories;

import com.aptech.de12.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method to find a user by email and password
    Optional<User> findByEmailAndPassword(String email, String password);
}

