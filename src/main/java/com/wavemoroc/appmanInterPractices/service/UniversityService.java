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
        return university;
    }

    public University getSafeUniversity(Long uniId) {
        if (universityRepository.findByUniId(uniId).isPresent()) {
            return universityRepository.findByUniId(uniId).get();
        } else {
            log.error("university id : " + uniId + " not found");
            throw new UniversityNotFoundException("university id : " + uniId + " not found");
        }
    }

    public University getSafeUniversity(String uniName) {
        if (universityRepository.findByUniName(uniName).isPresent()) {
            return universityRepository.findByUniName(uniName).get();
        } else {
            log.error("university name : " + uniName + " not found");
            throw new UniversityNotFoundException("university name : " + uniName + " not found");
        }
    }

    public List<University> getAllUniversity() {
        return universityRepository.findAll();
    }

    public University addUniversity(UniversityFormDTO dto) {
        if (dto.getUniName() != null && dto.getUniAddress() != null) {
            University university = save(new University(dto.getUniName(), dto.getUniAddress()));
            log.info("add university " + university.getUniName());
            return university;
        } else {
            log.error("University name or address can not nul");
            throw new InvalidFormException("University name or address can not null");
        }
    }

    public University updateUniversity(Long uniId, UniversityFormDTO dto) {
        if (dto.getUniName() != null && dto.getUniAddress() != null) {
            University university = getSafeUniversity(uniId);
            university.setUniAddress(dto.getUniAddress());
            university.setUniName(dto.getUniName());
            university = save(university);
            log.info("add university " + university.getUniName());
            return university;
        } else {
            log.error("University name or address can not null");
            throw new InvalidFormException("University name or address can not null");
        }
    }

    public void deleteUniversity(Long unId) {
        universityRepository.deleteByUniId(unId);
    }
}
