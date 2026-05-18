package com.bikash.hospital_management_system;

import com.bikash.hospital_management_system.entity.Appointment;
import com.bikash.hospital_management_system.entity.Patient;
import com.bikash.hospital_management_system.service.AppointmentService;
import com.bikash.hospital_management_system.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
public class AppointmentTest {

    @Autowired
    private  AppointmentService appointmentService;


}
