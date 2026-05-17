package com.bikash.hospital_management_system.repository;

import com.bikash.hospital_management_system.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}