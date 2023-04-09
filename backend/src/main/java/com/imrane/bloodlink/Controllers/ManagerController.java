package com.imrane.bloodlink.Controllers;


import com.imrane.bloodlink.Dto.Request.DonationDto;
import com.imrane.bloodlink.Dto.Response.DonationResponse;
import com.imrane.bloodlink.Entity.Donation;
import com.imrane.bloodlink.Service.DonationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final DonationService donationService;

    @GetMapping("/donations/{id}")
    public ResponseEntity<DonationResponse> getDonationsByHospital(@PathVariable Long id) {
        return new ResponseEntity<>(donationService.getDonationsByDonor(id), HttpStatus.OK);
    }
    @GetMapping("/donations")
    public ResponseEntity<List<Donation>> getDonations() {
        return new ResponseEntity<>(donationService.donationsbyManager(), HttpStatus.OK);
    }
    @PostMapping("/donations")
    public ResponseEntity<Donation> addDonation(@RequestBody DonationDto donation) {
        return new ResponseEntity<>(donationService.addDonation(donation), HttpStatus.CREATED);
    }
}
