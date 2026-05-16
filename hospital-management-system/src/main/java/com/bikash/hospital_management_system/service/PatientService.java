package com.bikash.hospital_management_system.service;

import com.bikash.hospital_management_system.entity.Patient;
import com.bikash.hospital_management_system.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id) {
        Patient patient1 = patientRepository.findById(id).orElse(null);
        Patient patient2 = patientRepository.findById(id).orElse(null);
        return patient1;
    }
}
