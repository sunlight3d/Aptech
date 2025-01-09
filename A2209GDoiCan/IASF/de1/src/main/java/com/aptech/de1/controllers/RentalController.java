package com.aptech.de1.controllers;

import com.aptech.de1.models.Rental;
import com.aptech.de1.services.rental.IRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    private IRentalService rentalService; //??
    @GetMapping("")
    public String index(
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            Model model) {
        Page<Rental> pageRental = rentalService.getRentalsWithDetails(page - 1, size, search);
        int totalPages = pageRental.getTotalPages();

        model.addAttribute("rentals", pageRental.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("search", search);

        return "rentals/index";
    }
}
