package com.wavemoroc.appmanInterPractices.service;

import com.wavemoroc.appmanInterPractices.entities.Student;
import com.wavemoroc.appmanInterPractices.exceptions.InvalidFormException;
import com.wavemoroc.appmanInterPractices.exceptions.StudentNotFoundException;
import com.wavemoroc.appmanInterPractices.repositories.StudentRepository;
import com.wavemoroc.appmanInterPractices.util.StudentFormDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;

    public Student getSafeStudent(Long stuId) {
        if (studentRepository.findStudentByStuId(stuId).isPresent()) {
            return studentRepository.findStudentByStuId(stuId).get();
        } else {
            throw new StudentNotFoundException("student id : " + stuId + " not found");
        }
    }

    public Student save(Student student) {
        student = studentRepository.save(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long stuId) {
        studentRepository.deleteByStuId(stuId);
    }

    public Student addStudent(StudentFormDTO dto) {
        if (dto.getFirstname() != null && dto.getLastname() != null) {
            Student student = save(new Student(dto.getFirstname(), dto.getLastname()));
            log.info("add student " + student.getFirstname());
            return student;
        } else {
            throw new InvalidFormException("firstname or lastname is null");
        }
    }

    public Student updateStudent(Long stuId, StudentFormDTO dto) {
        if (dto.getFirstname() != null && dto.getLastname() != null) {
            Student student = getSafeStudent(stuId);
            student.setFirstname(dto.getFirstname());
            student.setLastname(dto.getLastname());
            student = save(student);
            log.info("update student " + student.getFirstname());
            return student;
        } else {
            throw new InvalidFormException("firstname or lastname is null");
        }
    }
}
