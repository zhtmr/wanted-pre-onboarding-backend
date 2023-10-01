package com.example.wantedpreonboardingbackend.domain.jobadvertisement;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long 채용공고_id;

    private String 채용포지션;

    private Integer 채용보상금;

    private String 채용내용;

    private String 사용기술;

    @Builder
    public JobAdvertisement(String 채용포지션, Integer 채용보상금, String 채용내용, String 사용기술) {
        this.채용포지션 = 채용포지션;
        this.채용보상금 = 채용보상금;
        this.채용내용 = 채용내용;
        this.사용기술 = 사용기술;
    }
}
