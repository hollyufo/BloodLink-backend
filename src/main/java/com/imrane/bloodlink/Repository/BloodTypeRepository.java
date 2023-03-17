package com.imrane.bloodlink.Repository;

import com.imrane.bloodlink.Entity.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BloodTypeRepository extends JpaRepository<BloodType, Long> {
}
