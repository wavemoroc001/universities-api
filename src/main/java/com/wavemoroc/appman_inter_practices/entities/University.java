package com.wavemoroc.appman_inter_practices.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniId;
    private String uniName;
    private String uniAddress;

    @ManyToMany
    @JoinTable(name = "studentAdmission",
            joinColumns = {@JoinColumn(name = "uniId", referencedColumnName = "uniId")},
            inverseJoinColumns = {@JoinColumn(name = "stuId", referencedColumnName = "stuId")}
    )
    private List<Student> studentList;

    public University(String uniName, String uniAddress) {
        this.uniName = uniName;
        this.uniAddress = uniAddress;
    }
}
