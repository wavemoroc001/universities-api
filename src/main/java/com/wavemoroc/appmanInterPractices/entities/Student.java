package com.wavemoroc.appmanInterPractices.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stuId;
    private String firstname;
    private String lastname;

    @OneToMany(targetEntity = Admission.class)
    @JoinColumn(name = "studentId")
    private List<Admission> admissionList = new CopyOnWriteArrayList<>();

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
