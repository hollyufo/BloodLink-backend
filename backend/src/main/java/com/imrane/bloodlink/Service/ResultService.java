package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Entity.Result;
import com.imrane.bloodlink.Repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ResultService {

    private final ResultRepository resultRepository;


    // get result by donation id
    public Result findByDonationId(Long id) {
        return resultRepository.findByDonationId(id);
    }
}
