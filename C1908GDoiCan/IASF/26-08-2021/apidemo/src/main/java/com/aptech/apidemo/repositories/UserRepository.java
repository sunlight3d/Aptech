package com.aptech.apidemo.repositories;

import com.aptech.apidemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
