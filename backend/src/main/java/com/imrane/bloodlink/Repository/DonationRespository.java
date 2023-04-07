package com.imrane.bloodlink.Repository;

import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Entity.Donation;
import com.imrane.bloodlink.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DonationRespository extends JpaRepository<Donation, Long> {

    // getting all donations by donor
    List<Donation> findAllByDonor(AppUser donor);
    // getting all donations by hospital
    List<Donation> findAllByHospital(Hospital hospital);

    // get donation by id
    Donation findDonationById(Long id);


}
