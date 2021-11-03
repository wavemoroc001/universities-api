package com.wavemoroc.appmanInterPractices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniId;
    @Column(nullable = false)
    private String uniName;
    @Column(nullable = false)
    private String uniAddress;

    @OneToMany(targetEntity = Admission.class)
    @JoinColumn(name = "universityId")
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Admission> admissionList = new CopyOnWriteArrayList<>();

    public University(String uniName, String uniAddress) {
        this.uniName = uniName;
        this.uniAddress = uniAddress;
    }
}
