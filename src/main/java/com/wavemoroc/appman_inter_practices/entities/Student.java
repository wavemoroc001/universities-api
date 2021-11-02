package com.wavemoroc.appman_inter_practices.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "studentAdmission",
            joinColumns = {@JoinColumn(name = "stuId", referencedColumnName = "stuId")},
            inverseJoinColumns = {@JoinColumn(name = "uniId", referencedColumnName = "uniId")}
    )
    private List<University> universityList;

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
