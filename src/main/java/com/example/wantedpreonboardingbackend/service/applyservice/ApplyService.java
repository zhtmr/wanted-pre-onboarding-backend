package com.example.wantedpreonboardingbackend.service.applyservice;

import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisementRepository;
import com.example.wantedpreonboardingbackend.domain.user.User;
import com.example.wantedpreonboardingbackend.domain.user.UserRepository;
import com.example.wantedpreonboardingbackend.web.dto.ApplyRequestDto;
import com.example.wantedpreonboardingbackend.web.message.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final UserRepository userRepository;
    private final JobAdvertisementRepository jobAdvertisementRepository;


    @Transactional
    public Result<?> apply(ApplyRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. userId = " + requestDto.getUserId()));
        JobAdvertisement jobAdvertisement = jobAdvertisementRepository.findById(requestDto.getJob_advertisement_id()).orElseThrow(() -> new IllegalArgumentException("해당 공고가 없습니다. job_advertisement_id = " + requestDto.getJob_advertisement_id()));
        boolean check = jobAdvertisement.getUsers()
                .stream()
                .anyMatch(e -> e.getId().equals(user.getId()));
        if(check) {
            throw new IllegalArgumentException("해당 공고에 이미 지원한 내역이 있습니다.");
        }

        jobAdvertisement.addUsers(user);
        return new Result<>().setMessage("지원 완료");
    }
}
