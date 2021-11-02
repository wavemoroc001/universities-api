package com.wavemoroc.appman_inter_practices.repositories;

import com.wavemoroc.appman_inter_practices.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
