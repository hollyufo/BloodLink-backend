package com.imrane.bloodlink.Dto.Response;


import com.imrane.bloodlink.Entity.Donation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonationResponse {
    private String message;
    private List<Donation> donations;
}
