package com.bikash.hospital_management_system;

import com.bikash.hospital_management_system.repository.PatientRepository;
import com.bikash.hospital_management_system.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private final PatientService patientService;

    public PatientTest(PatientService patientService) {
        this.patientService = patientService;
    }

    @Test
    public void testPatientRepository() {
        patientRepository.findAll();
    }

    @Test
    public void testGetPatientById() {
        patientService.getPatientById(1L);
    }
}
