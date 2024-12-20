package com.aptech.demo.repositories;

import com.aptech.demo.models.Student;
import com.aptech.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
