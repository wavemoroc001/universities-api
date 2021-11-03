package com.wavemoroc.appmanInterPractices.service;

import com.wavemoroc.appmanInterPractices.entities.Admission;
import com.wavemoroc.appmanInterPractices.entities.Student;
import com.wavemoroc.appmanInterPractices.entities.University;
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

            universityService.save(new University("KKU", "23 Moo 16 Mittraphap Rd., Nai-Muang, Muang District, Khon Kaen 40002"));
            universityService.save(new University("CU", "254 Phayathai Rd, Wang Mai, Pathum Wan District, Bangkok 10330"));
            universityService.save(new University("KMUTT", "126 Pracha Uthit Rd, Khwaeng Bang Mot, Khet Thung Khru, Krung Thep Maha Nakhon 10140"));
            universityService.save(new University("KMITL", "1 Chalong Krung 1 Alley, Lat Krabang, Khet Lat Krabang, Krung Thep Maha Nakhon 10520"));
            universityService.save(new University("KU", "50 Thanon Phahon Yothin, Khwaeng Lat Yao, Khet Chatuchak, Krung Thep Maha Nakhon 10900"));


            Student student = studentService.save(new Student("John", "Grey"));

            admissionService.addAdmission(student, "2020", Admission.EDU_LEVEL.BACHELOR_DEGREE, universityService.getSafeUniversity("KMUTT"));
            admissionService.addAdmission(student, "2022", Admission.EDU_LEVEL.MASTER_DEGREE, universityService.getSafeUniversity("CU"));
            admissionService.addAdmission(student, "2025", Admission.EDU_LEVEL.PHD, universityService.getSafeUniversity("KU"));

            student = studentService.save(new Student("Eric", "Hank"));

            admissionService.addAdmission(student, "2020", Admission.EDU_LEVEL.BACHELOR_DEGREE, universityService.getSafeUniversity("KU"));
            admissionService.addAdmission(student, "2023", Admission.EDU_LEVEL.BACHELOR_DEGREE, universityService.getSafeUniversity("KKU"));

            student = studentService.save(new Student("Tom", "Hank"));
            admissionService.addAdmission(student, "2019", Admission.EDU_LEVEL.BACHELOR_DEGREE, universityService.getSafeUniversity("KMUTT"));
            admissionService.addAdmission(student, "2023", Admission.EDU_LEVEL.MASTER_DEGREE, universityService.getSafeUniversity("KMUTT"));

        };
    }
}
