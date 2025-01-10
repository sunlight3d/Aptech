package com.aptech.de1.controllers;

import com.aptech.de1.models.Rental;
import com.aptech.de1.models.Vehicle;
import com.aptech.de1.services.rental.*;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private VehicleService vehicleService;

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

    @PostMapping("/deleteRental/{id}")
    public String deleteRental(@PathVariable("id") Long id) {
        rentalService.deleteRental(id); // Your service method to delete the rental by ID
        return "redirect:/rentals"; // Redirect to the rental list or another page after deletion
    }

    @GetMapping("/createRental")
    public String showRentalForm(Model model) {
        // Fetch all customers and available vehicles (you may implement your own logic to get available vehicles)
        List<Customer> customers = customerService.findAll();
        List<Vehicle> availableVehicles = vehicleService.findAvailableVehicles(LocalDate.now());

        model.addAttribute("customers", customers);
        model.addAttribute("availableVehicles", availableVehicles);
        model.addAttribute("rental", new Rental());
        return "rentals/add";
    }
    @PostMapping("/createRental")
    public String createRental(@ModelAttribute("rental") Rental rental, BindingResult result, Model model) {
        // Validate the input
        if (rental.getRentalDate().isBefore(LocalDate.now())) {
            result.rejectValue("rentalDate", "error.rentalDate", "Rental date must be after today.");
        }

        if (rental.getReturnDate().isBefore(rental.getRentalDate())) {
            result.rejectValue("returnDate", "error.returnDate", "Return date must be after rental date.");
        }

        // Check if the vehicle is available for the specified dates
        if (!rentalService.isVehicleAvailable(rental.getVehicle(), rental.getRentalDate(), rental.getReturnDate())) {
            result.rejectValue("vehicle", "error.vehicle", "Vehicle is not available for the selected period.");
        }

        if (result.hasErrors()) {
            // Fetch the list of customers and available vehicles again to show them in case of errors
            List<Customer> customers = customerService.findAll();
            List<Vehicle> availableVehicles = vehicleService.findAvailableVehicles(LocalDate.now());
            model.addAttribute("customers", customers);
            model.addAttribute("availableVehicles", availableVehicles);
            return "rentals/add";//tại sao sau đoạn này model lại trống
            //return "redirect:/rentals/createRental";
        }

        // Save the rental
        rentalService.save(rental);
        return "redirect:/rentals"; // Redirect to the rental list page
    }
}
