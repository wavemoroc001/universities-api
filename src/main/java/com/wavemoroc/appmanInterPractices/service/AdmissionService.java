package com.wavemoroc.appmanInterPractices.service;

import com.wavemoroc.appmanInterPractices.entities.Admission;
import com.wavemoroc.appmanInterPractices.entities.Student;
import com.wavemoroc.appmanInterPractices.entities.University;
import com.wavemoroc.appmanInterPractices.repositories.AdmissionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AdmissionService {
    private final StudentService studentService;
    private final UniversityService universityService;
    private final AdmissionRepository admissionRepository;

    public void addAdmission(Student student, String gradYear, Admission.EDU_LEVEL eduLevel, University university) {
        Admission admission = admissionRepository.save(new Admission(gradYear,eduLevel));
        student.getAdmissionList().add(admission);
        university.getAdmissionList().add(admission);
        universityService.save(university);
        studentService.save(student);
    }
}
