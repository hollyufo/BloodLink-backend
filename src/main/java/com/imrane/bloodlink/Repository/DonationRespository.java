package com.imrane.bloodlink.Repository;

import com.imrane.bloodlink.Entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DonationRespository extends JpaRepository<Donation, Long> {
}
