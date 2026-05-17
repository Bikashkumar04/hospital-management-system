package com.bikash.hospital_management_system;

import com.bikash.hospital_management_system.entity.Patient;
import com.bikash.hospital_management_system.entity.type.BloodGroupType;
import com.bikash.hospital_management_system.repository.PatientRepository;
import com.bikash.hospital_management_system.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        patientRepository.findAll();
    }

    @Test
    public void testGetPatientById() {
        patientService.getPatientById(1L);
    }

    @Test
    public void testFindPatientByName() {
        Patient patient = patientRepository.findByName("John Doe");
        System.out.println(patient.getName());
    }

    @Test
    public void testFindPatientByDateOfBirthOrEmail() {
        List<Patient> patients = patientRepository.
                findByDateOfBirthOrEmail(LocalDate.of(2002,9,25),"john@gmail.com" );

        for(Patient patient:patients){
            System.out.println(patient.getName());
            System.out.println(patient);
        }

    }

    @Test
    public void testFindPatientByBloodGroup() {
        List<Patient> patients = patientRepository.
                findByPatientBYBloodGroup(BloodGroupType.A_NEGATIVE);

        for(Patient patient:patients){
            System.out.println(patient.getName());
            System.out.println(patient);
        }

    }
    @Test
    public void testCountBloodList() {
        Page<Object[]> bloodCounts = patientRepository.countBloodList(PageRequest.of(0, 10));

        for (Object[] bloodCount : bloodCounts) {
            System.out.println("Blood Group: " + bloodCount[0] + ", Count: " + bloodCount[1]);
        }
    }

    @Test
    public void testUpdateNameById() {

        int rowsUpdated = patientRepository.updateNameById(1L, "Jane Doe");
        System.out.println("Rows updated: " + rowsUpdated);
    }
}