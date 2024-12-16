package com.aptech.demo.controllers;

import com.aptech.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
