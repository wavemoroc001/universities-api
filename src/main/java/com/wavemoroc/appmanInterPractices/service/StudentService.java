package com.wavemoroc.appmanInterPractices.service;

import com.wavemoroc.appmanInterPractices.entities.Admission;
import com.wavemoroc.appmanInterPractices.entities.Student;
import com.wavemoroc.appmanInterPractices.entities.University;
import com.wavemoroc.appmanInterPractices.exceptions.StudentNotFoundException;
import com.wavemoroc.appmanInterPractices.repositories.AdmissionRepository;
import com.wavemoroc.appmanInterPractices.repositories.StudentRepository;
import com.wavemoroc.appmanInterPractices.repositories.UniversityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final AdmissionRepository admissionRepository;
    private final UniversityService universityService;

    public Student getSafeStudent(Long stuId) {
        if (studentRepository.findStudentByStuId(stuId).isPresent()) {
            return studentRepository.findStudentByStuId(stuId).get();
        } else {
            throw new StudentNotFoundException("student id : " + stuId + "not found");
        }
    }

    public Student save(Student student) {
        student = studentRepository.save(student);
        log.info("add/update student " + student.getFirstname());
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


}
