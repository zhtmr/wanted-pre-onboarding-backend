package com.example.wantedpreonboardingbackend.web.dto;

import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import lombok.Builder;
import lombok.Getter;

@Getter
public class JobAdvertisementResponseDto extends JobAdvertisementDefaultResponseDto {


    @Builder
    public JobAdvertisementResponseDto(JobAdvertisement entity) {
        this.job_advertisement_id = entity.getId();
        this.company_name = entity.getCompany().getName();
        this.nation = entity.getNation();
        this.region = entity.getRegion();
        this.position = entity.getPosition();
        this.reward = entity.getReward();
        this.skill = entity.getSkill();
    }


}
