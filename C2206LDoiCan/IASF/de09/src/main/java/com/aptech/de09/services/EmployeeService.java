package com.aptech.de09.services;

import com.aptech.de09.dtos.requests.EditEmployeeRequest;
import com.aptech.de09.dtos.requests.LoginRequest;
import com.aptech.de09.dtos.requests.NewEmployeeRequest;
import com.aptech.de09.dtos.responses.UserResponse;
import com.aptech.de09.models.Employee;

import java.util.List;


public interface EmployeeService {
    Employee insertEmployee(NewEmployeeRequest newEmployeeRequest);
    Employee updateEmployee(EditEmployeeRequest editEmployeeRequest);
    List<Employee> getAllEmployees();
    Employee getDetailEmployee(Long id);
    void deleteEmployee(Long id);
}

