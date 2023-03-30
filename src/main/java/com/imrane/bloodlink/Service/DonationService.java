package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Dto.Response.DonationResponse;
import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Entity.Donation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.imrane.bloodlink.Repository.DonationRespository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRespository donationRepository;

    // get all donations by a hospital
    public List<Donation> getDonationsByHospital(AppUser hospital) {
        return donationRepository.findAllByHospital(hospital);
    }

    // get all donation by logged in donor
    public DonationResponse getDonationsByDonor() {
        // getting the logged in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser donor = (AppUser) authentication.getPrincipal();
        // getting all donations by donor
        List<Donation> donations = donationRepository.findAllByDonor(donor);
        // return the list of donations
        return DonationResponse.builder()
                .message("Donations by " + donor.getUsername())
                .donations(donations)
                .build();
    }


}
