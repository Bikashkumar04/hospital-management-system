package com.bikash.hospital_management_system.service;

import com.bikash.hospital_management_system.entity.Insurance;
import com.bikash.hospital_management_system.entity.Patient;
import com.bikash.hospital_management_system.repository.InsuranceRepository;
import com.bikash.hospital_management_system.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final   InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
     public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
         Patient patient = patientRepository.findById(patientId).
                 orElseThrow(() -> new RuntimeException("Patient not found"));

         patient.setInsurance(insurance);

         insurance.setPatient(patient); // bi-directional association

        return patient;

     }

     @Transactional
    public Patient RemoveInsuranceFromPatient(Long patientId) {
         Patient patient = patientRepository.findById(patientId)
                 .orElseThrow(() -> new RuntimeException("Patient not found"));

         patient.setInsurance(null);

         return patient;
    }




}
