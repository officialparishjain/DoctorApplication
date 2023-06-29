package com.parishjain.DoctorApplication.controllers;

import com.parishjain.DoctorApplication.models.Doctor;
import com.parishjain.DoctorApplication.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    // Add Doctor
    @PostMapping(value = "/add")
    private ResponseEntity<String> createDoctor(@RequestBody Doctor doctor){
        HttpStatus status;
        String response;
        try{
            doctorService.addDoctor(doctor);
            status = HttpStatus.OK;
            response = "Doctor Added Successfully..";
        }
        catch (Exception ex){
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response = "Something went wrong ... Try Again after some time ..";
        }
        return ResponseEntity.status(status).body(response);
    }

}
