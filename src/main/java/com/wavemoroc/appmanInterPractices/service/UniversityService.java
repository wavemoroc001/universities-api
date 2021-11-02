package com.wavemoroc.appmanInterPractices.service;

import com.wavemoroc.appmanInterPractices.entities.University;
import com.wavemoroc.appmanInterPractices.exceptions.InvalidFormException;
import com.wavemoroc.appmanInterPractices.exceptions.UniversityNotFoundException;
import com.wavemoroc.appmanInterPractices.repositories.UniversityRepository;
import com.wavemoroc.appmanInterPractices.util.UniversityFormDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UniversityService {
    private final UniversityRepository universityRepository;

    public University save(University university) {
        university = universityRepository.save(university);
//        log.info("add/update university " + university.getUniName());
        return university;
    }

    public University getSafeUniversity(Long uniId) {
        if (universityRepository.findByUniId(uniId).isPresent()) {
            return universityRepository.findByUniId(uniId).get();
        } else {
            throw new UniversityNotFoundException("university id : " + uniId + " not found");
        }
    }

    public List<University> getAllUniversity() {
        return universityRepository.findAll();
    }

    public void deleteUniversity(University university) {
        universityRepository.delete(university);
    }

    public University addUniversity(UniversityFormDTO dto) {
        if (dto.getUniName() != null && dto.getUniAddress() != null) {
            University university = save(new University(dto.getUniName(), dto.getUniAddress()));
            log.info("add university " + university.getUniName());
            return university;
        } else {
            throw new InvalidFormException("University name or address can not null");
        }
    }
}
