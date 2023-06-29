package com.parishjain.DoctorApplication.repository;

import com.parishjain.DoctorApplication.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
