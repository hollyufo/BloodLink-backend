package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // getting list of users by role
    public List<AppUser> getUsersByRole(String role) {
        return userRepository.findAllByRole(role);
    }

    // getting user by id
    public AppUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // list of users by city
    public List<AppUser> getUsersByCity(String city) {
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
}