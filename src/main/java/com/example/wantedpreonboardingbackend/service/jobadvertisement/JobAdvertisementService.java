package com.example.wantedpreonboardingbackend.service.jobadvertisement;

import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisementRepository;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class JobAdvertisementService {
    private final JobAdvertisementRepository jobAdvertisementRepository;

    @Transactional
    public Long save(JobAdvertisementSaveRequestDto requestDto) {
        return jobAdvertisementRepository.save(requestDto.toEntity()).get채용공고_id();
    }
}
