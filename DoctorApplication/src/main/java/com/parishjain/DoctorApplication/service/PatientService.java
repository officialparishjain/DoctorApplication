package com.parishjain.DoctorApplication.service;

import com.parishjain.DoctorApplication.DTO.SuggestDoctorDto;
import com.parishjain.DoctorApplication.models.*;
import com.parishjain.DoctorApplication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorService doctorService;

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }


    public String suggestDoctor(Long id) {

        // First, we check if the patient with this ID is present or not
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isEmpty()) {
            return "Patient with this ID not found";
        }
        else
        {
            Patient patient = optionalPatient.get();
            String patientCity = String.valueOf(patient.getPatientCity());

            // Check if doctors are available in the patient's city
            if (!isCityPresent(patientCity)) {
                return "We are still waiting to expand to your location.";
            }

            // Getting speciality by symptom
            Speciality patientSpeciality = getSpecialityBySymptom(patient.getPatientSymptom());
            City city = City.valueOf(patient.getPatientCity());
            List<Doctor> doctorList = doctorService.getDoctorBySpecialityAndCity(patientSpeciality, city);
            System.out.println(doctorList);
            if (doctorList.isEmpty()) {
                return "There isn't any doctor present at your location for your symptom";
            }
            else {
                StringBuilder result = new StringBuilder();
                result.append("Doctors with the symptom in your location:\n\n");
                for (Doctor doctor : doctorList) {
                    result.append("Name: ").append(doctor.getDoctorName()).append("\n");
                    result.append("City: ").append(doctor.getDoctorCity()).append("\n");
                    result.append("Speciality: ").append(doctor.getDoctorSpeciality()).append("\n");
                    result.append("Phone Number: ").append(doctor.getDoctorPhone()).append("\n\n");
                }
                return result.toString();
            }
        }
    }

    public static boolean isCityPresent(String patientCity){
        for (City city : City.values()) {
            if (city.name().equals(patientCity)) return true;
        }
        return false;
    }

    public Speciality getSpecialityBySymptom(Symptoms symptom) {
        return switch (symptom) {
            case Arthritis, Back_Pain, Tissue_Injuries -> Speciality.Orthopedic;
            case Dysmenorrhea -> Speciality.Gynecology;
            case Skin_Infection, Skin_Burn -> Speciality.Dermatology;
            case Ear_Pain -> Speciality.ENT;
        };
    }
}
