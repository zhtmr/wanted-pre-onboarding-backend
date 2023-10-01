package com.example.wantedpreonboardingbackend.web.dto;

import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JobAdvertisementSaveRequestDto {

    private String 채용포지션;

    private Integer 채용보상금;

    private String 채용내용;

    private String 사용기술;

    @Builder
    public JobAdvertisementSaveRequestDto(String 채용포지션, Integer 채용보상금, String 채용내용, String 사용기술) {
        this.채용포지션 = 채용포지션;
        this.채용보상금 = 채용보상금;
        this.채용내용 = 채용내용;
        this.사용기술 = 사용기술;
    }

    public JobAdvertisement toEntity() {
        return JobAdvertisement.builder()
                .채용포지션(채용포지션)
                .채용보상금(채용보상금)
                .채용내용(채용내용)
                .사용기술(사용기술)
                .build();
    }
}
