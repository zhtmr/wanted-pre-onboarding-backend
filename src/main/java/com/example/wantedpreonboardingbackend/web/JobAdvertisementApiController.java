package com.example.wantedpreonboardingbackend.web;

import com.example.wantedpreonboardingbackend.service.jobadvertisement.JobAdvertisementService;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class JobAdvertisementApiController {

    private final JobAdvertisementService jobAdvertisementService;

    @PostMapping("/api/v1/jobadvertisements")
    public Long save(@RequestBody JobAdvertisementSaveRequestDto requestDto) {
        return jobAdvertisementService.save(requestDto);
    }
}
