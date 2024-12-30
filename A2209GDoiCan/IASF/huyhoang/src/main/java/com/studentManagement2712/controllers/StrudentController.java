package com.studentManagement2712.controllers;

import com.studentManagement2712.models.Student;
import com.studentManagement2712.repositories.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("students")
public class StrudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("")
    private String getStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("title", "Student List");
        model.addAttribute("students", students);
        return "students/index";
    }

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("title", "Add Student");
        model.addAttribute("student", new Student());
        return "students/add";
    }

    @PostMapping("/add")
    public String addStudent(
            @Valid Student student,
            BindingResult bindingResult,
            Model model) {
        // Check for validation errors
        if (bindingResult.hasErrors()) {
            return "students/add";
        }

        // Check if email already exists
        Optional<Student> existingStudent = studentRepository.findByEmail(student.getEmail());
        if (existingStudent.isPresent()) {
            model.addAttribute("emailError", "Email already exists");
            return "students/add";
        }

        // Save the student
        studentRepository.save(student);

        // Redirect to the student list
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        model.addAttribute("student", student);
        return "students/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(
            @PathVariable Long id,
            @ModelAttribute("student") @Valid Student student,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "students/edit";
        }
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDob(student.getDob());
        existingStudent.setMajor(student.getMajor());
        studentRepository.save(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        model.addAttribute("student", student);
        return "students/delete";
    }

    @PostMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam(required = false) String keyword, Model model) {
        List<Student> students;
        if (keyword != null && !keyword.isBlank()) {
            students = studentRepository.findByNameContainingOrEmailContaining(keyword, keyword);
        } else {
            students = studentRepository.findAll();
        }
        model.addAttribute("search", keyword);
        model.addAttribute("students", students);
        return "students/index";
    }

}
