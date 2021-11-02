package com.wavemoroc.appmanInterPractices.repositories;

import com.wavemoroc.appmanInterPractices.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByStuId(Long stuId);
}
