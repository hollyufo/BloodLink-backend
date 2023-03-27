package com.imrane.bloodlink.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {
        private String name;
        private String address;
        private String phone;
        private String email;
        private String image;
        private String map;
        private Long city;
        private Long manager;
}
