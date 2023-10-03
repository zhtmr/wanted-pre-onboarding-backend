package com.example.wantedpreonboardingbackend.domain.jobadvertisement;

import com.example.wantedpreonboardingbackend.domain.company.Company;
import com.example.wantedpreonboardingbackend.domain.user.User;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String position;

    private Integer reward;

    private String content;

    private String skill;

    private String nation;

    private String region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "jobAdvertisement")
    private List<User> users = new ArrayList<>();


    public void setCompany(Company company) {
        this.company = company;
    }

    public void addUsers(User user) {
        this.users.add(user);
        user.setJobAdvertisement(this);
    }

    @Builder
    public JobAdvertisement(String position, Integer reward, String content, String skill, String nation, String region, Company company) {
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.skill = skill;
        this.nation = nation;
        this.region = region;
        this.company = company;
    }


    public void update(JobAdvertisementUpdateRequestDto requestDto, Company company) {
        this.position = requestDto.getPosition();
        this.reward = requestDto.getReward();
        this.content = requestDto.getContent();
        this.skill = requestDto.getSkill();
        this.nation = requestDto.getNation();
        this.region = requestDto.getRegion();
        this.company = company;
    }



}
