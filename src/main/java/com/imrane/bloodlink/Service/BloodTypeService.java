package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Entity.BloodType;
import com.imrane.bloodlink.Entity.City;
import com.imrane.bloodlink.Exceptions.InvalidBloodTypeException;
import com.imrane.bloodlink.Repository.BloodTypeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
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
    @Transactional
    public BloodType createBloodType(BloodType bloodType) {
        try {
            if (bloodType == null) {
                throw new InvalidBloodTypeException("Blood type must not be null");
            }
            if (bloodType.getName() == null || bloodType.getName().isEmpty()) {
                throw new InvalidBloodTypeException("Blood type name must not be empty");
            }
            return bloodTypeRepository.save(bloodType);
        } catch (DataIntegrityViolationException e) {
            throw new InvalidBloodTypeException("Blood type name must be unique");
        }
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
