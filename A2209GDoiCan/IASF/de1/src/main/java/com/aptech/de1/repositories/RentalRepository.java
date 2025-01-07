package com.aptech.de1.repositories;

import com.aptech.de1.models.Customer;
import com.aptech.de1.models.Rental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    @Query("SELECT r FROM Rental r " +
            "JOIN FETCH r.customer c " +
            "JOIN FETCH r.vehicle v")
    Page<Rental> findAllRentalsWithDetails(Pageable pageable);
}
