package com.wavemoroc.appmanInterPractices.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemoroc.appmanInterPractices.entities.Student;
import com.wavemoroc.appmanInterPractices.service.AdmissionService;
import com.wavemoroc.appmanInterPractices.service.StudentService;
import com.wavemoroc.appmanInterPractices.util.StudentFormDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final AdmissionService admissionService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @GetMapping("/{stuId}")
    public ResponseEntity<?> getStudentByStuId(@PathVariable Long stuId) {
        return ResponseEntity.ok().body(studentService.getSafeStudent(stuId));
    }

    @DeleteMapping("/{stuId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long stuId) {
        admissionService.deleteAllAdmissionByStudId(stuId);
        studentService.deleteStudent(stuId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestParam String stuForm) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        StudentFormDTO dto = mapper.readValue(stuForm, StudentFormDTO.class);
        Student student = studentService.addStudent(dto);
        return ResponseEntity.created(URI.create("students/" + student.getStuId())).body(admissionService.getStudentDTO(student.getStuId()));
    }
}
