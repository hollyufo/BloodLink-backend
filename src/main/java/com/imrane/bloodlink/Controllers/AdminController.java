package com.imrane.bloodlink.Controllers;


import com.imrane.bloodlink.Dto.Request.HospitalDto;
import com.imrane.bloodlink.Dto.Response.HospitalResponse;
import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Entity.Hospital;
import com.imrane.bloodlink.Service.HospitalService;
import com.imrane.bloodlink.Service.UserService;
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
    private final UserService userService;

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
    // update a hospital
    @PutMapping("/hospital/{id}")
    public ResponseEntity<HospitalResponse> updateHospital(@PathVariable Long id, @RequestBody HospitalDto hospitalDto) {
        HospitalResponse hospitalResponse = hospitalService.updateHospital(id, hospitalDto);
        return new ResponseEntity<>(hospitalResponse, HttpStatus.OK);
    }

    // list of all the users
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllUsers() {
        List<AppUser> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // list of users by role
    @GetMapping("/users/{role}")
    public ResponseEntity<List<AppUser>> getUsersByRole(@PathVariable String role) {
        List<AppUser> users = userService.getUsersByRole(role);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // list of users by city
    @GetMapping("/users/city/{id}")
    public ResponseEntity<List<AppUser>> getUsersByCity(@PathVariable Long id) {
        List<AppUser> users = userService.getUsersByCity(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
