package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Dto.Response.AppUserResponse;
import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Entity.City;
import com.imrane.bloodlink.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CityService cityService;

    // find user by email
    public AppUser findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

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

    // get the user from the context and return the user information
    public AppUserResponse viewProfile() {
        // getting the user from the context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) authentication.getPrincipal();

        // returning the user information
        return AppUserResponse.builder()
                .appUser(user)
                .message("User information retrieved successfully")
                .build();
    }
    public AppUserResponse updateProfile() {
        // getting the user from the context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) authentication.getPrincipal();

        // returning the user information
        return AppUserResponse.builder()
                .appUser(user)
                .message("User information retrieved successfully")
                .build();
    }
}
