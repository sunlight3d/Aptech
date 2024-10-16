package com.aptech.de09.repositories;

import com.aptech.de09.models.Employee;
import com.aptech.de09.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}