package com.bikash.hospital_management_system.entity;

import com.bikash.hospital_management_system.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@ToString

@Getter
@Setter

@Table(
        name = "patient",
        uniqueConstraints = {
//                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(name = "name_dob_unique", columnNames = {"name", "dateOfBirth"})
        },
        indexes = {
                @Index(name = "unique_patient_email", columnList = "email"),
        }
)
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String name;

    private int age;

//    @ToString.Exclude
    private LocalDate dateOfBirth;

    private String gender;

    @Column(unique = true,nullable = true)
    private String email;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne
    @JoinColumn(name = "insurance_id", referencedColumnName = "id") //owning side of the relationship
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointment;


}
