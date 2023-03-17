package com.imrane.bloodlink.Repository;

import com.imrane.bloodlink.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
