package com.example.wantedpreonboardingbackend.web.dto;

import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import lombok.Builder;
import lombok.Getter;

@Getter
public class JobAdvertisementResponseDto {

    /*
    *  "채용공고_id": 채용공고_id,
	  "회사명":"원티드랩",
	  "국가":"한국",
	  "지역":"서울",
	  "채용포지션":"백엔드 주니어 개발자",
	  "채용보상금":1500000,
	  "사용기술":"Python"
    * */
    private Long job_advertisement_id;

    private String company_name;

    private String nation;

    private String region;

    private String position;

    private Integer reward;

    private String skill;

    private String content;


    @Builder
    public JobAdvertisementResponseDto(JobAdvertisement entity) {
        this.job_advertisement_id = entity.getId();
        this.company_name = entity.getCompany().getName();
        this.nation = entity.getNation();
        this.region = entity.getRegion();
        this.position = entity.getPosition();
        this.reward = entity.getReward();
        this.skill = entity.getSkill();
        this.content = entity.getContent();
    }

}
