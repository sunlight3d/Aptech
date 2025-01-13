package com.aptech.de1.controllers;
import com.aptech.de1.models.Customer;
import com.aptech.de1.repositories.CustomerRepository;
import com.aptech.de1.repositories.RentalRepository;
import com.aptech.de1.services.rental.IRentalService;
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
    private IRentalService rentalService; //??
    @GetMapping("")
    public String index(Model model) {
        return "index";

    }
}
