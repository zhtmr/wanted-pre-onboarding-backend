package com.example.wantedpreonboardingbackend.web.dto;

import lombok.Getter;

@Getter
public class JobAdvertisementDefaultResponseDto {
    /*
        *  "채용공고_id": 채용공고_id,
          "회사명":"원티드랩",
          "국가":"한국",
          "지역":"서울",
          "채용포지션":"백엔드 주니어 개발자",
          "채용보상금":1500000,
          "사용기술":"Python"
        * */
    protected Long job_advertisement_id;
    protected String company_name;
    protected String nation;
    protected String region;
    protected String position;
    protected Integer reward;
    protected String skill;


}
