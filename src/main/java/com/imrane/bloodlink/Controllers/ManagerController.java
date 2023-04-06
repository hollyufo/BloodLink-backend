package com.imrane.bloodlink.Controllers;


import com.imrane.bloodlink.Dto.Response.DonationResponse;
import com.imrane.bloodlink.Service.DonationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final DonationService donationService;

    @GetMapping("/donations/{id}")
    public ResponseEntity<DonationResponse> getDonationsByHospital(@PathVariable Long id) {
        return new ResponseEntity<>(donationService.getDonationsByDonor(id), HttpStatus.OK);
    }
}
