package com.wavemoroc.appmanInterPractices.repositories;

import com.wavemoroc.appmanInterPractices.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University,Long> {
    Optional<University> findByUniId(Long uId);
}
