package com.example.wantedpreonboardingbackend.web.dto;

import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class JobAdvertisementDetailResponseDto extends JobAdvertisementDefaultResponseDto {

    private String content;
    private List<Long> otherJobAdvertisementIdList = new ArrayList<>();


    @Builder
    public JobAdvertisementDetailResponseDto(JobAdvertisement entity, List<Long> otherJobAdvertisementIdList) {
        this.job_advertisement_id = entity.getId();
        this.company_name = entity.getCompany().getName();
        this.nation = entity.getNation();
        this.region = entity.getRegion();
        this.position = entity.getPosition();
        this.reward = entity.getReward();
        this.skill = entity.getSkill();
        this.content = entity.getContent();
        this.otherJobAdvertisementIdList = otherJobAdvertisementIdList;
    }




}
