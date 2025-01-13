package com.aptech.de1.services.rental;

import com.aptech.de1.models.Rental;
import com.aptech.de1.models.Vehicle;
import com.aptech.de1.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAvailableVehicles(LocalDate date) {
        return vehicleRepository.findAvailableVehicles(date);
    }
}
