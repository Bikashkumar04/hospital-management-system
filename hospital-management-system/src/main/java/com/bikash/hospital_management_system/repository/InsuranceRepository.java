package com.bikash.hospital_management_system.repository;

import com.bikash.hospital_management_system.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}