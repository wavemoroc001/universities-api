package com.wavemoroc.appmanInterPractices.repositories;

import com.wavemoroc.appmanInterPractices.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByStuId(Long stuId);

    @Modifying
    @Transactional
    void deleteByStuId(Long stuId);
}
