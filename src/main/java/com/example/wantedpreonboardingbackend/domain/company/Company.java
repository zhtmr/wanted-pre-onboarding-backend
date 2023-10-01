package com.example.wantedpreonboardingbackend.domain.company;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long 회사_id;

    private String 회사명;

    private String 국가;

    private String 지역;

    @Builder
    public Company(String 회사명, String 국가, String 지역) {
        this.회사명 = 회사명;
        this.지역 = 지역;
        this.국가 = 국가;
    }

}
