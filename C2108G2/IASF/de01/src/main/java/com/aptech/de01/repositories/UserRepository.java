package com.aptech.de01.repositories;
import com.aptech.de01.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<com.aptech.de01.models.User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}