package com.aptech.de02.repositories;
import com.aptech.de02.models.Appointment;
import com.aptech.de02.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a " +
            "JOIN FETCH a.doctor d " +
            "JOIN FETCH a.patient p")
    Page<Appointment> findAllAppointmentsWithDetails(Pageable pageable);

    @Query("SELECT a FROM Appointment a " +
            "JOIN FETCH a.doctor d " +
            "JOIN FETCH a.patient p " +
            "WHERE LOWER(d.firstName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(d.name) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(p.firstName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Appointment> findAllAppointmentsWithSearch(@Param("search") String search, Pageable pageable);

    List<Appointment> findByPatientAndAppointmentDateBetween(Patient patient, LocalDate startDate, LocalDate endDate);
}