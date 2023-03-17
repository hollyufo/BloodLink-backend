package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Dto.Request.HospitalDto;
import com.imrane.bloodlink.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final CityService cityService;



    // create a hospital
    public void createHospital(HospitalDto hospitalDto) {
        // getting the city

    }
    // update a hospital
    public void updateHospital() {
        // TODO
    }
    // delete a hospital
    public void deleteHospital() {
        // TODO
    }
    // get all hospitals
    public void getAllHospitals() {
        // TODO
    }
    // get a hospital by id
    public void getHospitalById() {
        // TODO
    }
    // get a hospital by name
    public void getHospitalByName() {
        // TODO
    }
    // get a hospital by location
    public void getHospitalByLocation() {
        // TODO
    }
}
