package com.wavemoroc.appmanInterPractices.service;

import com.wavemoroc.appmanInterPractices.entities.University;
import com.wavemoroc.appmanInterPractices.exceptions.UniversityNotFoundException;
import com.wavemoroc.appmanInterPractices.repositories.UniversityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UniversityService {
    private final UniversityRepository universityRepository;

    public University save(University university) {
        university = universityRepository.save(university);
        log.info("add/update university " + university.getUniName());
        return university;
    }

    public University getSafeUniversity(Long uniId) {
        if (universityRepository.findByUniId(uniId).isPresent()) {
            return universityRepository.findByUniId(uniId).get();
        } else {
            throw new UniversityNotFoundException("university id : " + uniId + " not found");
        }
    }
}
