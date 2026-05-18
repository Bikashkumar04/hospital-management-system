package com.bikash.hospital_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;


    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departmentSet = new HashSet<>();
}
