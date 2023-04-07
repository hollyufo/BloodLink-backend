package com.imrane.bloodlink.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {

        @NotNull(message = "Name is required")
        private String name;
        @NotNull(message = "Address is required")
        private String address;
        @NotNull(message = "Phone is required")
        private String phone;
        @NotNull(message = "Email is required")
        private String email;
        @NotNull(message = "Map is required")

        private String map;
        @NotNull(message = "City is required")
        private Long city;
        @NotNull(message = "Manager is required")
        private Long manager;
}
