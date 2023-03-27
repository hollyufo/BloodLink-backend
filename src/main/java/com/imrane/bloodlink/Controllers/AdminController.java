package com.imrane.bloodlink.Controllers;


import com.imrane.bloodlink.Dto.Request.HospitalDto;
import com.imrane.bloodlink.Dto.Response.HospitalResponse;
import com.imrane.bloodlink.Entity.Hospital;
import com.imrane.bloodlink.Service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final HospitalService hospitalService;

    // creating a new hospital
    @PostMapping("/hospital")
    public ResponseEntity<HospitalResponse> createHospital(@RequestBody HospitalDto hospital){
        return null;
    }
    // view all hospitals
    @GetMapping("/hospitals")
    public List<Hospital> viewAllHospitals() {
        return hospitalService.getAllHospitals();
    }
    // get a snigle hospital
    @GetMapping("/hospital/{id}")
    public Hospital getHospitalById(@PathVariable Long id) {
        return hospitalService.getHospitalById(id);
    }
}
