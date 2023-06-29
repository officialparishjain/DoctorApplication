package com.parishjain.DoctorApplication.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long patientId;

    @Size(min = 3,message = "Name should contain at least 3 characters.")
    @Column(name = "Name")
    private String patientName;

    @Size(max = 20,message = "City name should contains max 20 characters")
    @Column(name = "City")
    private String patientCity;

    @Email(message = "Email should be in proper email format like abc@gmail.com")
    @Column(name = "Email",unique = true)
    private String patientEmail;

    @Size(min = 10,message = "Phone number should contains at least 10 numbers")
    @Column(name = "Phone Number",unique = true)
    private String patientPhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "Symptom")
    private Symptoms patientSymptom;

}
