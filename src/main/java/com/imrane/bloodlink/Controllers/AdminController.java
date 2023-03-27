package com.imrane.bloodlink.Controllers;


import com.imrane.bloodlink.Dto.Request.HospitalDto;
import com.imrane.bloodlink.Dto.Response.HospitalResponse;
import com.imrane.bloodlink.Entity.Hospital;
import com.imrane.bloodlink.Service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        HospitalResponse newHospital = hospitalService.createHospital(hospital);
        HospitalResponse hospitalResponse = new HospitalResponse(newHospital.getHospital(), "Hospital created successfully");
        return new ResponseEntity<>(hospitalResponse, HttpStatus.CREATED);
    }
    // view all hospitals
    @GetMapping("/hospital")
    public List<Hospital> viewAllHospitals() {
        return hospitalService.getAllHospitals();
    }
    // get a snigle hospital
    @GetMapping("/hospital/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id) {
        Hospital hospital = hospitalService.getHospitalById(id).getHospital();
        return new ResponseEntity<>(hospital, HttpStatus.OK);
    }
}
