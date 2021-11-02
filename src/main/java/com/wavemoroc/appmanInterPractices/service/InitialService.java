package com.wavemoroc.appmanInterPractices.service;

import com.wavemoroc.appmanInterPractices.entities.Admission;
import com.wavemoroc.appmanInterPractices.entities.Student;
import com.wavemoroc.appmanInterPractices.entities.University;
import com.wavemoroc.appmanInterPractices.repositories.AdmissionRepository;
import com.wavemoroc.appmanInterPractices.repositories.StudentRepository;
import com.wavemoroc.appmanInterPractices.repositories.UniversityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitialService {

    @Bean
    CommandLineRunner runner(StudentService studentService,
                             AdmissionService admissionService,
                             UniversityService universityService) {
        return args -> {

            University university = universityService.save(new University("KU", "address"));
            Student student = studentService.save(new Student("Supatra", "Wongvaree"));
            admissionService.addAdmission(student,"2020", Admission.EDU_LEVEL.BACHELOR_DEGREE,university);
            admissionService.addAdmission(student,"2022", Admission.EDU_LEVEL.MASTER_DEGREE,university);
            admissionService.addAdmission(student,"2025", Admission.EDU_LEVEL.PHD,university);


//            studentAdmissionRepository.save(new Admission("2560", Admission.EDU_LEVEL.BACHELOR_DEGREE, s, u));
//            studentAdmissionRepository.save(new Admission("2562", Admission.EDU_LEVEL.MASTER_DEGREE, s, u));
//
//
//            u = universityRepository.save(new University("CU", "address"));
//            s = studentRepository.save(new Student("Pornpavee", "Supattatham"));
//            studentAdmissionRepository.save(new Admission("2559", Admission.EDU_LEVEL.BACHELOR_DEGREE, s, u));
//
//
//            u = universityRepository.save(new University("KKU", "address"));
//            s = studentRepository.save(new Student("Ramida", "Wongtee"));
//            studentAdmissionRepository.save(new Admission("2561", Admission.EDU_LEVEL.BACHELOR_DEGREE, s, u));


        };
    }
}
