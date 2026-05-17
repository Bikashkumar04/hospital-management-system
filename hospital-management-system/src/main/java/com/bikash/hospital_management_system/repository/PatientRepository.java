package com.bikash.hospital_management_system.repository;

import com.bikash.hospital_management_system.entity.Patient;
import com.bikash.hospital_management_system.entity.type.BloodGroupType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    List<Patient> findByDateOfBirthOrEmail(LocalDate dateOfBirth, String email);

    @Query("SELECT p from Patient p where p.bloodGroup =?1")
    List<Patient> findByPatientBYBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p.bloodGroup, COUNT(p) FROM Patient p  GROUP BY p.bloodGroup")
    Page<Object[]> countBloodList(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameById(@Param("id") Long id, @Param("name") String name);

}

