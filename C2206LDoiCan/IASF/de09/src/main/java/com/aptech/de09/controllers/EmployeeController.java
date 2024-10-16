package com.aptech.de09.controllers;
import com.aptech.de09.dtos.requests.EditEmployeeRequest;
import com.aptech.de09.dtos.requests.NewEmployeeRequest;
import com.aptech.de09.models.Employee;
import com.aptech.de09.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
//http://localhost:8088/employees/insert
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/insert")
    public String insert(
            @ModelAttribute("newEmployeeRequest") NewEmployeeRequest newEmployeeRequest,
            @ModelAttribute("editEmployeeRequest") EditEmployeeRequest editEmployeeRequest,

            Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee/insert";//view path
    }

    @PostMapping("/addEmployee")
    public String addEmployee(
            @ModelAttribute("newEmployeeRequest") NewEmployeeRequest newEmployeeRequest,
            @ModelAttribute("editEmployeeRequest") EditEmployeeRequest editEmployeeRequest,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            // handle errors
            return "employee/insert";
        }
        // Save the employee information, assuming there's a service to handle the logic
        employeeService.insertEmployee(newEmployeeRequest);
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("message", "Employee added successfully!");
        return "employee/insert";
    }
    @PostMapping("/editEmployee")
    public String editEmployee(@ModelAttribute("editEmployeeRequest") EditEmployeeRequest editEmployeeRequest,
                               @ModelAttribute("newEmployeeRequest") NewEmployeeRequest newEmployeeRequest,
                               BindingResult result, Model model) {
        employeeService.updateEmployee(editEmployeeRequest);
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee/insert";
    }
}
