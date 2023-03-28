package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Entity.City;
import com.imrane.bloodlink.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CityService cityService;

    // getting list of users by role
    public List<AppUser> getUsersByRole(String role) {
        return userRepository.findAllByRole(role);
    }

    // getting user by id
    public AppUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // list of users by city
    public List<AppUser> getUsersByCity(Long id) {
        // getting the city by id
        City city = cityService.getCityById(id);

        return userRepository.findAllByCity(city);
    }
    // getting user by email
    public AppUser getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    // delete user by id
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User deleted";
    }

    // update user role
    public AppUser updateUser(AppUser user) {
        // saving the user
        return userRepository.save(user);
    }

    // get list of all users
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }
}
