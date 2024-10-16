package com.exam.springde01.repositories;

import com.exam.springde01.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsernameAndPassword(String username, String password);
}
