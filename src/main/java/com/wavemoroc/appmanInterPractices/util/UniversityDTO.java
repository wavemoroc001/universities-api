package com.wavemoroc.appmanInterPractices.util;

import com.wavemoroc.appmanInterPractices.entities.University;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UniversityDTO {
    private Long uniId;
    private String uniName;
    private String uniAddress;
    private List<StudentDTO> studentList;

    public UniversityDTO(University university, List<StudentDTO> studentDTOList) {
        this.studentList = studentDTOList;
        this.uniId = university.getUniId();
        this.uniAddress = university.getUniAddress();
        this.uniName = university.getUniName();
    }
}
