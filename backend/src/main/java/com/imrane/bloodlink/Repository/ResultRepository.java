package com.imrane.bloodlink.Repository;

import com.imrane.bloodlink.Entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {


    // get all the results of a donation
    public Result findByDonationId(Long id);
}
