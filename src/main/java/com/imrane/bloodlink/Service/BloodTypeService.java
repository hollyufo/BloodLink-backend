package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Entity.BloodType;
import com.imrane.bloodlink.Entity.City;
import com.imrane.bloodlink.Repository.BloodTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BloodTypeService {

    private final BloodTypeRepository bloodTypeRepository;

    // get all blood types
    public List<BloodType> getAllBloodTypes() {
        return bloodTypeRepository.findAll();
    }
    // get blood type by id
    public Optional<BloodType> getBloodTypeById(Long id) {
        return bloodTypeRepository.findById(id);
    }
    // get blood type by name
    public Optional<BloodType> getBloodTypeByName(String name) {
        return bloodTypeRepository.findByName(name);
    }
    // create blood type
    public City createBloodType() {
        // TODO
        return null;
    }
    // update blood type
    public void updateBloodType() {
        // TODO
    }
    // delete blood type
    public void deleteBloodType() {
        // TODO
    }

}
