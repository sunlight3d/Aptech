package aptech.de2.repositories;

import aptech.de2.models.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT a FROM Appointment a " +
            "JOIN a.doctor d " +
            "JOIN a.patient p")
    Page<Appointment> findAllAppointmentsWithDetails(Pageable pageable);

    @Query("SELECT a FROM Appointment a " +
            "JOIN a.doctor d " +
            "JOIN a.patient p " +
            "WHERE LOWER(p.firstName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(a.status) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Appointment> findAllAppointmentsWithSearch(@Param("search") String search, Pageable pageable);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
            "FROM Appointment a " +
            "WHERE a.doctor.id = :doctorId " +
            "AND a.appointmentDate BETWEEN :appointmentDateStart AND :appointmentDateEnd " +
            "AND a.status <> 'Completed'")
    boolean isDoctorAvailable(@Param("doctorId") Integer doctorId,
                              @Param("appointmentDateStart") LocalDateTime appointmentDateStart,
                              @Param("appointmentDateEnd") LocalDateTime appointmentDateEnd);



}

