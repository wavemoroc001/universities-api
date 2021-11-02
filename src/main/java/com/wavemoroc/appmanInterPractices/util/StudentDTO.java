package com.wavemoroc.appmanInterPractices.util;

import com.wavemoroc.appmanInterPractices.entities.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {
    private Long studentId;
    private String firstname;
    private String lastname;
    private List<AdmissionDTO> admissionList;

    public StudentDTO(Student student, List<AdmissionDTO> admissionDTOList) {
        this.studentId = student.getStuId();
        this.firstname = student.getFirstname();
        this.lastname = student.getLastname();
        this.admissionList = admissionDTOList;
    }
}
