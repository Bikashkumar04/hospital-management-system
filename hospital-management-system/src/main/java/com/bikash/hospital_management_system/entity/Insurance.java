package com.bikash.hospital_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Modifying;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String insuranceCompany;

    @Column(nullable = false,unique = true, length = 50)
    private String policyNumber;

    @Column(nullable = false)
    private String validityPeriod;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDate createdAt;


    @OneToOne(mappedBy = "insurance") //inverse side of the relationship
    private Patient patient;



}
