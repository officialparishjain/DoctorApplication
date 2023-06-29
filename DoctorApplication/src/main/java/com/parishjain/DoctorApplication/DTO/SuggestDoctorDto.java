package com.parishjain.DoctorApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuggestDoctorDto {

    private String doctorName;
    private String doctorCity;
    private String doctorPhone;
    private String doctorEmail;


}
