package com.wavemoroc.appmanInterPractices.repositories;

import com.wavemoroc.appmanInterPractices.entities.Admission;
import com.wavemoroc.appmanInterPractices.util.AdmissionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {
    @Query("select new com.wavemoroc.appmanInterPractices.util.AdmissionDTO(a.studentId,a.eduLevel,a.graduatedYear,u.uniId,u.uniName ) " +
            " from Admission a join University  u on u.uniId = a.universityId " +
            "where a.studentId = :stuId ")
    List<AdmissionDTO> getAdmissionList(Long stuId);

}
