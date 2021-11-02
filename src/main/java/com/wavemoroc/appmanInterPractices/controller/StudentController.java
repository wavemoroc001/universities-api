package com.wavemoroc.appmanInterPractices.controller;

import com.wavemoroc.appmanInterPractices.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @GetMapping("/{stuId}")
    public ResponseEntity<?> getStudentByStuId(@PathVariable Long stuId) {
        return ResponseEntity.ok().body(studentService.getSafeStudent(stuId));
    }
}
