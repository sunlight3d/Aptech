package com.aptech.de1.repositories;

import com.aptech.de1.models.Customer;
import com.aptech.de1.models.Rental;
import com.aptech.de1.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query("SELECT r FROM Rental r " +
            "JOIN FETCH r.customer c " +
            "JOIN FETCH r.vehicle v")
    Page<Rental> findAllRentalsWithDetails(Pageable pageable);

    @Query("SELECT r FROM Rental r " +
            "JOIN FETCH r.customer c " +
            "JOIN FETCH r.vehicle v " +
            "WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(v.make) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(v.model) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Rental> findAllRentalsWithSearch(@Param("search") String search, Pageable pageable);
    List<Rental> findByVehicleAndRentalDateBetween(Vehicle vehicle, LocalDate rentalDate, LocalDate returnDate);
}

