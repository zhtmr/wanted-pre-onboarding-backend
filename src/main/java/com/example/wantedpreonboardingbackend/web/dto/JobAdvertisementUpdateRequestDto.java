package com.example.wantedpreonboardingbackend.web.dto;

import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class JobAdvertisementUpdateRequestDto {

    /*
    *     "채용포지션":"백엔드 주니어 개발자",
          "채용보상금":1500000, # 변경됨
          "채용내용":"원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..", # 변경됨
          "사용기술":"Python"
    * */

    private String position;

    private Integer reward;

    private String content;

    private String skill;

    private String nation;

    private String region;

    @Builder
    public JobAdvertisementUpdateRequestDto(String position, Integer reward, String content, String skill, String nation, String region) {
        this.position = position;
        this.reward = reward;
        this.skill = skill;
        this.content = content;
        this.nation = nation;
        this.region = region;
    }

    public JobAdvertisement toEntity() {
        return JobAdvertisement.builder()
                .position(position)
                .reward(reward)
                .content(content)
                .skill(skill)
                .nation(nation)
                .region(region)
                .build();
    }
}
