package com.aptech.de1.de1.controllers;
import com.aptech.de1.de1.CustomerRepository;
import com.aptech.de1.de1.models.Customer;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;
    @GetMapping("")
    public String index(Model model) {
        Customer customerA = new Customer();
        customerA.setEmail("aadda@gmail.com");
        customerA.setFirstName("nguyen");
        customerA.setLastName("van a");
        customerA.setPhone("09327237623");
        repository.save(customerA);
        return "index";

    }
}
