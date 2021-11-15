package com.wavemoroc.appmanInterPractices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admissionId;
    private String graduatedYear;
    @Enumerated(EnumType.STRING)
    private EDU_LEVEL eduLevel;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "studentId")
    private Student student;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "universityId")
    private University university;

    public static enum EDU_LEVEL {
        BACHELOR_DEGREE, MASTER_DEGREE, PHD
    }

    public Admission(String graduatedYear, EDU_LEVEL eduLevel) {
        this.graduatedYear = graduatedYear;
        this.eduLevel = eduLevel;
    }
}
