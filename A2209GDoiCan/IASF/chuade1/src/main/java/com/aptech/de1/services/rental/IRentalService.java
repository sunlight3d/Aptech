package com.aptech.de1.services.rental;

import com.aptech.de1.models.Rental;
import com.aptech.de1.models.Vehicle;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface IRentalService {
    Page<Rental> getRentalsWithDetails(int page, int size, String search);
    void deleteRental(Long id);
    public boolean isVehicleAvailable(Vehicle vehicle, LocalDate rentalDate, LocalDate returnDate);
    void save(Rental rental);
}
