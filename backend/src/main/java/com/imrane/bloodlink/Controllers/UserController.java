package com.imrane.bloodlink.Controllers;


import com.imrane.bloodlink.Dto.Response.AppUserResponse;
import com.imrane.bloodlink.Dto.Response.DonationResponse;
import com.imrane.bloodlink.Entity.Posts;
import com.imrane.bloodlink.Repository.PostRepository;
import com.imrane.bloodlink.Service.DonationService;
import com.imrane.bloodlink.Service.PostService;
import com.imrane.bloodlink.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final DonationService donationService;

    private final PostService postService;

    // view profile information
    @GetMapping("/profile")
    public ResponseEntity<AppUserResponse> viewProfile() {
        return new ResponseEntity<>(userService.viewProfile(), HttpStatus.OK);
    }
    @PutMapping("/profile")
    public ResponseEntity<AppUserResponse> updateProfile() {
        return new ResponseEntity<>(userService.updateProfile(), HttpStatus.OK);
    }

    // get all the donation for the logged in user
    @GetMapping("/donations")
    public ResponseEntity<DonationResponse> getDonations() {
        return new ResponseEntity<>(donationService.getDonationsByDonor(), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Posts>> getPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

}
