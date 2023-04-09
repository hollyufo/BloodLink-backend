package com.imrane.bloodlink.Repository;

import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    // get hospital by manager
    Hospital findByManager(AppUser manager);
}
