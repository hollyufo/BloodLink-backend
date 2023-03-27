package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Dto.Request.HospitalDto;
import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Entity.City;
import com.imrane.bloodlink.Entity.Hospital;
import com.imrane.bloodlink.Exceptions.HospitalNotFoundException;
import com.imrane.bloodlink.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final CityService cityService;

    private final UserService userService;



    // create a hospital
    public Hospital createHospital(HospitalDto hospitalDto) {
        // getting the city
        City city = cityService.getCityById(hospitalDto.getCity());
        AppUser manager = userService.getUserById(hospitalDto.getManager());
        // creating a new hospital
        Hospital hospital = Hospital.builder()
                .name(hospitalDto.getName())
                .address(hospitalDto.getAddress())
                .phone(hospitalDto.getPhone())
                .email(hospitalDto.getEmail())
                .image(hospitalDto.getImage())
                .map(hospitalDto.getMap())
                .city(city)
                .manager(manager)
                .build();
        return hospitalRepository.save(hospital);
    }
    // update a hospital
    public Hospital updateHospital(HospitalDto hospitalDto) {
        // TODO
        return null;
    }
    // delete a hospital
    public void deleteHospital() {
        // TODO
    }
    // get all hospitals
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }
    // get a hospital by id
    public Hospital getHospitalById(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent()) {
            return hospital.get();
        }else {
            // throw an exception
            throw new HospitalNotFoundException(id);
        }
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
