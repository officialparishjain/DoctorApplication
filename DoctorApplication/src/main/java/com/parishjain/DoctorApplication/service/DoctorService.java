package com.parishjain.DoctorApplication.service;

import com.parishjain.DoctorApplication.models.City;
import com.parishjain.DoctorApplication.models.Doctor;
import com.parishjain.DoctorApplication.models.Speciality;
import com.parishjain.DoctorApplication.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctorBySpecialityAndCity(Speciality patientSpeciality, City patientCity) {
        return doctorRepository.getDoctorByDoctorSpecialityAndDoctorCity(patientSpeciality,patientCity);
    }
}
