package com.wavemoroc.appmanInterPractices.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemoroc.appmanInterPractices.entities.University;
import com.wavemoroc.appmanInterPractices.service.AdmissionService;
import com.wavemoroc.appmanInterPractices.service.UniversityService;
import com.wavemoroc.appmanInterPractices.util.UniversityFormDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/universities")
public class UniversityController {
    private final UniversityService universityService;
    private final AdmissionService admissionService;

    @GetMapping
    public ResponseEntity<?> getAllUniversity() {
        return ResponseEntity.ok().body(universityService.getAllUniversity());
    }

    @GetMapping("/{uniId}")
    public ResponseEntity<?> getUniversityByUniId(@PathVariable Long uniId) {
        return ResponseEntity.ok().body(admissionService.getUniversityDTO(uniId));
    }

    @PostMapping
    public ResponseEntity<?> addUniversity(@RequestParam String uniForm) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        UniversityFormDTO dto = mapper.readValue(uniForm, UniversityFormDTO.class);
        University university = universityService.addUniversity(dto);
        return ResponseEntity.ok().body(admissionService.getUniversityDTO(university.getUniId()));
    }

    @PutMapping("/{uniId}")
    public ResponseEntity<?> updateUniversity(@PathVariable Long uniId, @RequestParam String uniForm) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        UniversityFormDTO dto = mapper.readValue(uniForm, UniversityFormDTO.class);
        University university = universityService.updateUniversity(uniId, dto);
        return ResponseEntity.created(URI.create("universities/" + university.getUniId())).body(admissionService.getUniversityDTO(university.getUniId()));
    }
}
