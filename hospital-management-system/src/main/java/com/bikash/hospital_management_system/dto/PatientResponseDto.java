package com.bikash.hospital_management_system.dto;

import com.bikash.hospital_management_system.entity.type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponseDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private BloodGroupType bloodGroup;
}
