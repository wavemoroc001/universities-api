package com.wavemoroc.appmanInterPractices.repositories;

import com.wavemoroc.appmanInterPractices.entities.Admission;
import com.wavemoroc.appmanInterPractices.util.AdmissionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {
    @Query("select new com.wavemoroc.appmanInterPractices.util.AdmissionDTO(a.admissionId,a.eduLevel,a.graduatedYear,u.uniId,u.uniName ) " +
            " from Admission a join University  u on u.uniId = a.universityId " +
            "where a.studentId = :stuId ")
    List<AdmissionDTO> getAdmissionDTOList(Long stuId);

    @Query("select distinct a.studentId from Admission a where a.universityId=:uniId")
    List<Long> getStudentIdInUniversityList(Long uniId);


    @Modifying
    @Transactional
    void deleteAllByStudentId(Long stuId);

    @Modifying
    @Transactional
    void deleteAllByUniversityId(Long uniId);
}
