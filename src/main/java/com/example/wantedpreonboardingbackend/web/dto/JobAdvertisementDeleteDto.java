package com.example.wantedpreonboardingbackend.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobAdvertisementDeleteDto {
    private Long job_advertisement_id;
}
