package com.bikash.hospital_management_system.service;

import com.bikash.hospital_management_system.dto.AppointmentResponseDto;
import com.bikash.hospital_management_system.entity.Appointment;
import com.bikash.hospital_management_system.entity.Doctor;
import com.bikash.hospital_management_system.entity.Patient;
import com.bikash.hospital_management_system.repository.AppointmentRepository;
import com.bikash.hospital_management_system.repository.DoctorRepository;
import com.bikash.hospital_management_system.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import com.bikash.hospital_management_system.dto.CreateAppointmentRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentResponseDto createNewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto){
        Long doctorId = createAppointmentRequestDto.getDoctorId();
        Long patientId = createAppointmentRequestDto.getPatientId();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientId));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + doctorId));
        Appointment appointment = Appointment.builder()
                .reason(createAppointmentRequestDto.getReason())
                .appointmentDate(LocalDate.from(createAppointmentRequestDto.getAppointmentTime()))
                .build();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointment().add(appointment);

        appointment = appointmentRepository.save(appointment);
        return modelMapper.map(appointment, AppointmentResponseDto.class);
    }


        @Transactional
        public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
            Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
            Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

            appointment.setDoctor(doctor); // this will automatically call the update, because it is dirty

            doctor.getAppointments().add(appointment); // just for bidirectional consistency

            return appointment;
        }

        public List<AppointmentResponseDto> getAllAppointmentsOfDoctor(Long doctorId) {
            Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

            return doctor.getAppointments()
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentResponseDto.class))
                    .collect(Collectors.toList());
        }
}