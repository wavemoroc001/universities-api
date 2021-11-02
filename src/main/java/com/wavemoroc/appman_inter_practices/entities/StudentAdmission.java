package com.wavemoroc.appman_inter_practices.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class StudentAdmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admissionId;
    private String graduatedYear;
    @Enumerated(EnumType.STRING)
    private EDU_LEVEL eduLevel;
    private Long stuId;
    private Long uniId;

    public static enum EDU_LEVEL {
        BACHELOR_DEGREE, MASTER_DEGREE, PHD
    }
}
