package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Entity.City;
import com.imrane.bloodlink.Exceptions.CityNotFoundException;
import com.imrane.bloodlink.Repository.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CityService {

    final CityRepository cityRepository;
    // getting city by id
    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }
    // getting all cities
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
    // creating city
    @Transactional
    public City createCity(City city) {
        return cityRepository.save(city);
    }
    // updating city
    public City updateCity(City city) {
        City existingCity = cityRepository.findById(city.getId()).orElse(null);
        existingCity.setName(city.getName());
        return cityRepository.save(existingCity);
    }
    // deleting city
    public String deleteCity(Long id) {
        cityRepository.deleteById(id);
        return "City removed !! " + id;
    }

}
