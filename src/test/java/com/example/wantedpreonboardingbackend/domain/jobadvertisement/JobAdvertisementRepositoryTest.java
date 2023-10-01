package com.example.wantedpreonboardingbackend.domain.jobadvertisement;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobAdvertisementRepositoryTest {

    @Autowired
    JobAdvertisementRepository repository;

    @After
    public void cleanup() {
        repository.deleteAll();
    }

    @Test
    public void 채용공고저장_불러오기() {
        /* given
            "채용포지션":"백엔드 주니어 개발자",
            "채용보상금":1500000,
            "채용내용":"원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..",
            "사용기술":"Python"

         */
        String 채용포지션 = "백엔드 주니어 개발자";
        Integer 채용보상금 = 1500000;
        String 채용내용 = "원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..";
        String 사용기술 = "Python";

        repository.save(JobAdvertisement.builder()
                .채용포지션(채용포지션)
                .채용보상금(채용보상금)
                .채용내용(채용내용)
                .사용기술(사용기술)
                .build());

        // when
        List<JobAdvertisement> jobAdvertisements = repository.findAll();

        // then
        JobAdvertisement jobAdvertisement = jobAdvertisements.get(0);
        assertThat(jobAdvertisement.get사용기술()).isEqualTo(사용기술);
        assertThat(jobAdvertisement.get채용포지션()).isEqualTo(채용포지션);
        assertThat(jobAdvertisement.get채용보상금()).isEqualTo(채용보상금);
        assertThat(jobAdvertisement.get채용내용()).isEqualTo(채용내용);
    }
}