package com.wavemoroc.appmanInterPractices.util;

import com.wavemoroc.appmanInterPractices.entities.Admission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdmissionDTO {
    private Long admissionID;
    private String eduLevel;
    private String graduatedYear;
    private Long uniId;
    private String universityName;

    public AdmissionDTO(Long admissionID, Admission.EDU_LEVEL eduLevel, String graduatedYear, Long uniId, String universityName) {
        this.admissionID = admissionID;
        this.eduLevel = eduLevel.toString();
        this.graduatedYear = graduatedYear;
        this.uniId = uniId;
        this.universityName = universityName;
    }
}
