package com.aptech.de02.repositories;
import com.aptech.de02.models.Doctor;
import com.aptech.de02.models.Patient;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
