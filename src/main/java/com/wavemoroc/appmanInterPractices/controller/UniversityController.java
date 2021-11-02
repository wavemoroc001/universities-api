package com.wavemoroc.appmanInterPractices.controller;

import com.wavemoroc.appmanInterPractices.service.UniversityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/universities")
public class UniversityController {
    private UniversityService universityService;

    @GetMapping
    public ResponseEntity<?> getAllUniversity() {
        return ResponseEntity.ok().body(universityService.getAllUniversity());
    }

    @GetMapping("/{uniId}")
    public ResponseEntity<?> getUniversityByUniId(@PathVariable Long uniId) {
        return ResponseEntity.ok().body(universityService.getSafeUniversity(uniId));
    }
}
