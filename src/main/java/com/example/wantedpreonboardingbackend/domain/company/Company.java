package com.example.wantedpreonboardingbackend.domain.company;


import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @OneToMany(mappedBy = "company")
    private List<JobAdvertisement> jobAdvertisements = new ArrayList<>();

    public void addJobAdvertisement(JobAdvertisement jobAdvertisement) {
        jobAdvertisements.add(jobAdvertisement);
        jobAdvertisement.setCompany(this);
    }

    @Builder
    public Company(String name, List<JobAdvertisement> jobAdvertisements) {
        this.name = name;
        this.jobAdvertisements = jobAdvertisements;
    }

}
