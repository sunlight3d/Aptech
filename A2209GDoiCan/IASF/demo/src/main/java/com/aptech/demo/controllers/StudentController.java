package com.aptech.demo.controllers;

import com.aptech.demo.dtos.requests.InsertStudentRequest;
import com.aptech.demo.models.Student;
import com.aptech.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        String title = "Haha";
        model.addAttribute("title", title);
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
        Student newStudent = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .dob(request.getDob())
                .major(request.getMajor())
                .build();
        studentRepository.save(newStudent);
        return "students/add";
    }

}
