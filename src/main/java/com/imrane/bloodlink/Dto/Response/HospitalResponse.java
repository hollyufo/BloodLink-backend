package com.imrane.bloodlink.Dto.Response;

import com.imrane.bloodlink.Entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Hospital hospital;
    private String message;

}
