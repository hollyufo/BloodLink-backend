package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Dto.Request.HospitalDto;
import com.imrane.bloodlink.Dto.Response.HospitalResponse;
import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Entity.City;
import com.imrane.bloodlink.Entity.Hospital;
import com.imrane.bloodlink.Entity.Role;
import com.imrane.bloodlink.Exceptions.CityNotFoundException;
import com.imrane.bloodlink.Exceptions.HospitalNotFoundException;
import com.imrane.bloodlink.Exceptions.InvalidHospitalRequest;
import com.imrane.bloodlink.Exceptions.UserNotFoundException;
import com.imrane.bloodlink.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final CityService cityService;

    private final UserService userService;


    public HospitalResponse createHospital(HospitalDto hospitalDto) {

        // Check if the city and manager exist
        City city = cityService.getCityById(hospitalDto.getCity());
        if(city == null) {
            throw new CityNotFoundException(hospitalDto.getCity());
        }
        AppUser manager = userService.getUserById(hospitalDto.getManager());
        // chcecking if the role of the manager is manager
        if(manager.getRole() != Role.MANAGER) {
            // change the role of the user to manager
            manager.setRole(Role.MANAGER);
            userService.updateUser(manager);
        }
        if(manager == null) {
            throw new UserNotFoundException(hospitalDto.getManager());
        }
        // Create a new hospital
        Hospital hospital = Hospital.builder()
                .name(hospitalDto.getName())
                .address(hospitalDto.getAddress())
                .phone(hospitalDto.getPhone())
                .email(hospitalDto.getEmail())
                .map(hospitalDto.getMap())
                .city(city)
                .manager(manager)
                .build();

        hospitalRepository.save(hospital);

        return HospitalResponse.builder()
                .hospital(hospital)
                .message("Hospital created successfully")
                .build();
    }

    public HospitalResponse getHospitalById(Long hospitalId) {
        // Check if the hospital exists
        Hospital hospital = hospitalRepository.findById(hospitalId).orElse(null);
        if(hospital == null) {
            throw new HospitalNotFoundException(hospitalId);
        }

        return HospitalResponse.builder()
                .hospital(hospital)
                .build();
    }

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public HospitalResponse updateHospital(Long hospitalId, HospitalDto hospitalDto) {
        // Check if the hospital exists
        Hospital hospital = hospitalRepository.findById(hospitalId).orElse(null);
        // check if the hospital exists
        if(hospital == null) {
            throw new HospitalNotFoundException(hospitalId);
        }

        // Check if the city and manager exist
        City city = cityService.getCityById(hospitalDto.getCity());
        if(city == null) {
            throw new CityNotFoundException(hospitalDto.getCity());
        }

        AppUser manager = userService.getUserById(hospitalDto.getManager());
        if(manager == null) {
            throw new UserNotFoundException(hospitalDto.getManager());
        }

        // Update the hospital
        hospital.setName(hospitalDto.getName());
        hospital.setAddress(hospitalDto.getAddress());
        hospital.setPhone(hospitalDto.getPhone());
        hospital.setEmail(hospitalDto.getEmail());
        hospital.setMap(hospitalDto.getMap());
        hospital.setCity(city);
        hospital.setManager(manager);

        hospitalRepository.save(hospital);

        return HospitalResponse.builder()
                .hospital(hospital)
                .message("Hospital updated successfully")
                .build();
    }

    // delete a hospital
    public void deleteHospital() {
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
