package com.aptech.de1.services.rental;

import com.aptech.de1.models.Rental;
import com.aptech.de1.models.Vehicle;
import com.aptech.de1.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalService implements IRentalService{
    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Page<Rental> getRentalsWithDetails(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (search != null && !search.isBlank()) {
            return rentalRepository.findAllRentalsWithSearch(search, pageable);
        }
        return rentalRepository.findAllRentalsWithDetails(pageable);
    }

    @Override
    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }

    @Override
    public boolean isVehicleAvailable(Vehicle vehicle, LocalDate rentalDate, LocalDate returnDate) {
        // Check if the vehicle is already rented within the specified period
        List<Rental> existingRentals = rentalRepository.findByVehicleAndRentalDateBetween(vehicle, rentalDate, returnDate);
        return existingRentals.isEmpty(); // If the list is empty, the vehicle is available
    }

    @Override
    public void save(Rental rental) {
        rentalRepository.save(rental);
    }
}
