package com.wavemoroc.appmanInterPractices.service;

import com.wavemoroc.appmanInterPractices.entities.Admission;
import com.wavemoroc.appmanInterPractices.entities.Student;
import com.wavemoroc.appmanInterPractices.entities.University;
import com.wavemoroc.appmanInterPractices.repositories.AdmissionRepository;
import com.wavemoroc.appmanInterPractices.util.StudentDTO;
import com.wavemoroc.appmanInterPractices.util.UniversityDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Slf4j
public class AdmissionService {
    private final StudentService studentService;
    private final UniversityService universityService;
    private final AdmissionRepository admissionRepository;

    public void addAdmission(Student student, String gradYear, Admission.EDU_LEVEL eduLevel, University university) {
        Admission admission = admissionRepository.save(new Admission(gradYear, eduLevel));
        student.getAdmissionList().add(admission);
        university.getAdmissionList().add(admission);
        universityService.save(university);
        studentService.save(student);
    }

    public StudentDTO getStudentDTO(Long stuId) {
        Student student = studentService.getSafeStudent(stuId);
        var admissionList = admissionRepository.getAdmissionDTOList(stuId);
        return new StudentDTO(student, admissionList);
    }

    public UniversityDTO getUniversityDTO(Long uniId) {
        University university = universityService.getSafeUniversity(uniId);
        var stuIdList = admissionRepository.getStudentIdInUniversityList(uniId);
        var studentDTOList = new ArrayList<StudentDTO>();
        for (Long stuId : stuIdList) {
            studentDTOList.add(getStudentDTO(stuId));
        }
        return new UniversityDTO(university, studentDTOList);
    }

    public void deleteAllAdmissionByStudId(Long stuId) {
        admissionRepository.deleteAllByStudentId(stuId);
    }

    public void deleteAllAdmissionByUniId(Long uniId) {
        admissionRepository.deleteAllByUniversityId(uniId);
    }

}
