package com.example.wantedpreonboardingbackend.web.dto;

import com.example.wantedpreonboardingbackend.domain.company.Company;
import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JobAdvertisementSaveRequestDto {

    private String position;

    private Integer reward;

    private String content;

    private String skill;

    private String nation;

    private String region;


    @Builder
    public JobAdvertisementSaveRequestDto(String position, Integer reward, String content, String skill, String nation, String region) {
        this.position = position;
        this.reward = reward;
        this.skill = skill;
        this.content = content;
        this.nation = nation;
        this.region = region;
    }

    public JobAdvertisement toEntity(Company company) {
        return JobAdvertisement.builder()
                .position(position)
                .reward(reward)
                .content(content)
                .skill(skill)
                .nation(nation)
                .region(region)
                .company(company)
                .build();
    }
}
