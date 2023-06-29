package com.parishjain.DoctorApplication.controllers;
import com.parishjain.DoctorApplication.DTO.SuggestDoctorDto;
import com.parishjain.DoctorApplication.models.Patient;
import com.parishjain.DoctorApplication.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping(value = "/add")
    private ResponseEntity<String> createDoctor(@RequestBody Patient patient){
        HttpStatus status;
        String response;
        try{
            patientService.addPatient(patient);
            status = HttpStatus.OK;
            response = "Patient Added Successfully..";
        }
        catch (Exception ex){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response = "Something went wrong ... Try Again after some time ..";
        }
        return ResponseEntity.status(status).body(response);
    }


    // Suggesting Patient to the Doctors
    @GetMapping(value = "/suggest/{id}")
    private ResponseEntity<String> suggestDoctor(@PathVariable Long id){
        String res;
        HttpStatus status;
        try{
            res = patientService.suggestDoctor(id);
            status  = HttpStatus.OK;
        }
        catch (Exception ex){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            res = "Something went wrong ... + ex";
        }
        return ResponseEntity.status(status).body(res);
    }
}
