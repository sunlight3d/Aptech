package com.aptech.de1.repositories;
import com.aptech.de1.models.Customer;
import com.aptech.de1.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v WHERE v.id NOT IN (" +
            "SELECT r.vehicle.id FROM Rental r WHERE :date BETWEEN r.rentalDate AND r.returnDate)")
    List<Vehicle> findAvailableVehicles(@Param("date") LocalDate date);
}
