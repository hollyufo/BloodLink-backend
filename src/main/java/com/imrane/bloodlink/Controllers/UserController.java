package com.imrane.bloodlink.Controllers;


import com.imrane.bloodlink.Dto.Response.AppUserResponse;
import com.imrane.bloodlink.Entity.AppUser;
import com.imrane.bloodlink.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // view profile information
    @GetMapping("/profile")
    public ResponseEntity<AppUserResponse> viewProfile() {
        return new ResponseEntity<>(userService.viewProfile(), HttpStatus.OK);
    }
}
