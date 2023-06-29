package com.parishjain.DoctorApplication.repository;

import com.parishjain.DoctorApplication.models.City;
import com.parishjain.DoctorApplication.models.Doctor;
import com.parishjain.DoctorApplication.models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    List<Doctor> getDoctorByDoctorSpecialityAndDoctorCity(Speciality doctorSpeciality,City doctorCity);


}
