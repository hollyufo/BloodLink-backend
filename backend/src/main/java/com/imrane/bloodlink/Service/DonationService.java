package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Dto.Request.DonationDto;
import com.imrane.bloodlink.Dto.Response.DonationResponse;
import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Entity.Donation;
import com.imrane.bloodlink.Entity.Hospital;
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
    private final HospitalService hospitalService;

    // get all donations by a hospital
    public List<Donation> getDonationsByHospital(Hospital hospital) {
        return donationRepository.findAllByHospital(hospital);
    }

    public List<Donation> donationsbyManager(){
        // get current logged in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser manager = (AppUser) authentication.getPrincipal();
        // get all hospitals by manager
        Hospital hospitals = hospitalService.gethospitalbymaager(manager);
        // get donations by hospital
        return donationRepository.findAllByHospital(hospitals);
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
    public DonationResponse getDonationsByDonor(Long id){
        // getting the logged in user
        AppUser donor = (AppUser) donationRepository.findDonationById(id).getDonor();
        // getting all donations by donor
        List<Donation> donations = donationRepository.findAllByDonor(donor);
        // return the list of donations
        return DonationResponse.builder()
                .message("Donations by " + donor.getUsername())
                .donations(donations)
                .build();
    }
    public Donation addDonation(DonationDto donation) {
        // getting the logged in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser donor = (AppUser) authentication.getPrincipal();
        // getting the hospital
        Hospital hospital = hospitalService.getHospitalBy1Id(donation.getHospital());
        // creating the donation
        Donation newDonation = Donation.builder()
                .donor(donor)
                .hospital(hospital)
                .date(donation.getDate())
                .build();
        // saving the donation
        return donationRepository.save(newDonation);
    }

}
