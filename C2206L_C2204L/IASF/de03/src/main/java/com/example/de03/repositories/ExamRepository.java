package com.example.de03.repositories;

import com.example.de03.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    //viết hàm join dữ liệu 3 bảng Exam, Scheduler, ExamAttendance
}
