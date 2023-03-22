package com.imrane.bloodlink.Repository;

import com.imrane.bloodlink.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    List<AppUser> findAllByRole(String role);

    List<AppUser> findAllByCity(String city);
}