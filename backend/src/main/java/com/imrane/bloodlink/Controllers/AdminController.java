package com.imrane.bloodlink.Controllers;


import com.imrane.bloodlink.Dto.Request.HospitalDto;
import com.imrane.bloodlink.Dto.Response.AppUserResponse;
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

    /**
     * Create a new hospital
     *
     * @param hospital the hospital information to be created
     * @return the newly created hospital information along with a success message
     */
    @PostMapping("/hospital")
    public ResponseEntity<HospitalResponse> createHospital(@RequestBody HospitalDto hospital){
        HospitalResponse newHospital = hospitalService.createHospital(hospital);
        HospitalResponse hospitalResponse = new HospitalResponse(newHospital.getHospital(), "Hospital created successfully");
        return new ResponseEntity<>(hospitalResponse, HttpStatus.CREATED);
    }


    /**
     * Get all hospitals
     *
     * @return a list of all hospitals
     */
    @GetMapping("/hospital")
    public List<Hospital> viewAllHospitals() {
        return hospitalService.getAllHospitals();
    }


    /**
     * Get a single hospital by id
     *
     * @param id the id of the hospital to be retrieved
     * @return the hospital information with the given id
     */
    @GetMapping("/hospital/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id) {
        Hospital hospital = hospitalService.getHospitalById(id).getHospital();
        return new ResponseEntity<>(hospital, HttpStatus.OK);
    }


    /**
     * Update a hospital with the given id
     *
     * @param id the id of the hospital to be updated
     * @param hospitalDto the updated hospital information
     * @return the updated hospital information along with a success message
     */
    @PutMapping("/hospital/{id}")
    public ResponseEntity<HospitalResponse> updateHospital(@PathVariable Long id, @RequestBody HospitalDto hospitalDto) {
        HospitalResponse hospitalResponse = hospitalService.updateHospital(id, hospitalDto);
        return new ResponseEntity<>(hospitalResponse, HttpStatus.OK);
    }

    /**
     * Get all users
     *
     * @return a list of all users
     */
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllUsers() {
        List<AppUser> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Get all users with the given role
     *
     * @param role the role of the users to be retrieved
     * @return a list of all users with the given role
     */

    @GetMapping("/users/{role}")
    public ResponseEntity<List<AppUser>> getUsersByRole(@PathVariable String role) {
        List<AppUser> users = userService.getUsersByRole(role);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Get all users in the given city
     *
     * @param id the id of the city of the users to be retrieved
     * @return a list of all users in the given city
     */
    @GetMapping("/users/city/{id}")
    public ResponseEntity<List<AppUser>> getUsersByCity(@PathVariable Long id) {
        List<AppUser> users = userService.getUsersByCity(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<AppUserResponse> viewProfile() {
        return new ResponseEntity<>(userService.viewProfile(), HttpStatus.OK);
    }
}
