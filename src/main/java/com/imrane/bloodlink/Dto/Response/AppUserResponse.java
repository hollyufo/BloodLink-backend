package com.imrane.bloodlink.Dto.Response;

import com.imrane.bloodlink.Entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserResponse {

    private String message;
    private AppUser appUser;
}
