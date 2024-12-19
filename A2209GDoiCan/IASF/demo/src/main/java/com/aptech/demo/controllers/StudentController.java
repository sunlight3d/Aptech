package com.aptech.demo.controllers;

import com.aptech.demo.dtos.requests.InsertStudentRequest;
import com.aptech.demo.models.Student;
import com.aptech.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("")
    public String getStudents(@RequestParam(name="page", required=false, defaultValue="1") Integer page,
                              @RequestParam(name="limit", required=false, defaultValue= "5") Integer limit,
                              Model model
                              ) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        //return new ModelAndView("students/index");
        return "students/index";
        //http://localhost:8082/students/
    }
    @GetMapping("/add")
    //http://localhost:8082/students/add
    public String addStudent(Model model) {
        model.addAttribute("request", new InsertStudentRequest());
        return "students/add";
    }
    @PostMapping("/add")
    public String insertStudent(@ModelAttribute("request") InsertStudentRequest request,  Model model) {
        //convert InsertStudentRequest to model
        Student newStudent = Student.fromRequest(request);
        studentRepository.save(newStudent);
        // Redirect về endpoint danh sách sinh viên
        return "redirect:/students"; // Redirect đến @GetMapping("")
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Long studentId, Model model) {
        studentRepository.findById(studentId)
                .ifPresent(student -> model.addAttribute("student", student));
        return "students/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable("id") Long studentId,
                                @ModelAttribute("student") Student updatedStudent) {
        // Find the existing student by ID
        studentRepository.findById(studentId).ifPresent(existingStudent -> {
            // Update fields
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setDob(updatedStudent.getDob());
            existingStudent.setMajor(updatedStudent.getMajor());
            // Save updated student
            studentRepository.save(existingStudent);
        });

        // Redirect to the list of students
        return "redirect:/students"; // Redirect to @GetMapping("")
    }
}
