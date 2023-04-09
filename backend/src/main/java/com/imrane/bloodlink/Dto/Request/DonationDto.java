package com.imrane.bloodlink.Dto.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonationDto {

    private Long donor;
    private Long hospital;
    private Date date;
}
