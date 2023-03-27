package com.imrane.bloodlink.Controllers;


import com.imrane.bloodlink.Dto.Request.HospitalDto;
import com.imrane.bloodlink.Entity.Hospital;
import com.imrane.bloodlink.Service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final HospitalService hospitalService;

    // creating a new hospital
    @PostMapping("/hospital")
    public Hospital createHospital(HospitalDto hospital){
        return hospitalService.createHospital(hospital);
    }
    // view all hospitals
    @GetMapping("/hospitals")
    public void viewAllHospitals() {
        // TODO
    }
}
