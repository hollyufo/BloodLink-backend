package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Dto.Request.HospitalDto;
import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Entity.City;
import com.imrane.bloodlink.Entity.Hospital;
import com.imrane.bloodlink.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
