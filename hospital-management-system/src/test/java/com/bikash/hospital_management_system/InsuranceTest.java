package com.bikash.hospital_management_system;

import com.bikash.hospital_management_system.entity.Appointment;
import com.bikash.hospital_management_system.entity.Doctor;
import com.bikash.hospital_management_system.entity.Insurance;
import com.bikash.hospital_management_system.entity.Patient;
import com.bikash.hospital_management_system.service.AppointmentService;
import com.bikash.hospital_management_system.service.InsuranceService;
import org.antlr.v4.runtime.misc.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private com.bikash.hospital_management_system.repository.DoctorRepository doctorRepository;

    @Test
    public void testInsuranceCreation() {
        Insurance insurance =Insurance.builder()
                .insuranceCompany("HealthCare Inc.")
                .policyNumber("HC123456789")
                .validityPeriod(LocalDate.of(2030, 12, 31))
                .build();
        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println("Insurance assigned to patient: " + patient.getName());
    }

    @Test
    public void testRemoveInsurance() {
        Patient patient = insuranceService.RemoveInsuranceFromPatient(1L);

        System.out.println("Insurance removed from patient: " + patient.getName());
    }

}
