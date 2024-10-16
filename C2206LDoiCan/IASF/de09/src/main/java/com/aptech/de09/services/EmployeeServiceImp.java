package com.aptech.de09.services;

import com.aptech.de09.dtos.requests.EditEmployeeRequest;
import com.aptech.de09.dtos.requests.NewEmployeeRequest;
import com.aptech.de09.models.Employee;
import com.aptech.de09.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImp implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee insertEmployee(NewEmployeeRequest newEmployeeRequest) {
        Employee newEmployee = Employee.builder()
                .name(newEmployeeRequest.getName())
                .email(newEmployeeRequest.getEmail())
                .address(newEmployeeRequest.getAddress())
                .build();
        return employeeRepository.save(newEmployee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(EditEmployeeRequest editEmployeeRequest) {
        Long id = editEmployeeRequest.getId();
        // Find the employee and update fields only if present
        return employeeRepository.findById(id)
                .map(employee -> {
                    if (editEmployeeRequest.getName() != null) {
                        employee.setName(editEmployeeRequest.getName());
                    }
                    if (editEmployeeRequest.getAddress() != null) {
                        employee.setAddress(editEmployeeRequest.getAddress());
                    }
                    if (editEmployeeRequest.getEmail() != null) {
                        employee.setEmail(editEmployeeRequest.getEmail());
                    }
                    // Save updates
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getDetailEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            // Xử lý khi không tìm thấy Employee
            // Ví dụ, bạn có thể trả về null, hoặc ném một ngoại lệ tùy chỉnh
            throw new EntityNotFoundException("Employee with ID " + id + " not found");
        }
        return optionalEmployee.get();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
