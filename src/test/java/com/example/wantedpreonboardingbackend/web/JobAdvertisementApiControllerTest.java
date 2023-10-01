package com.example.wantedpreonboardingbackend.web;

import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisementRepository;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobAdvertisementApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;

    @After
    public void tearDown() {
        jobAdvertisementRepository.deleteAll();
    }

    @Test
    public void JobAdvertisement_등록() {
        /*
         given
            "채용포지션":"백엔드 주니어 개발자",
            "채용보상금":1500000,
            "채용내용":"원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..",
            "사용기술":"Python"
         */
        String 채용포지션 = "백엔드 주니어 개발자";
        Integer 채용보상금 = 1500000;
        String 채용내용 = "원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..";
        String 사용기술 = "Python";
        JobAdvertisementSaveRequestDto requestDto = JobAdvertisementSaveRequestDto.builder()
                .채용포지션(채용포지션)
                .채용보상금(채용보상금)
                .사용기술(사용기술)
                .채용내용(채용내용)
                .build();

        String url = "http://localhost:" + port + "/api/v1/job-advertisements";

        // when
        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<JobAdvertisement> jobAdvertisements = jobAdvertisementRepository.findAll();
        assertThat(jobAdvertisements.get(0).get채용포지션()).isEqualTo(채용포지션);
        assertThat(jobAdvertisements.get(0).get채용보상금()).isEqualTo(채용보상금);
        assertThat(jobAdvertisements.get(0).get채용내용()).isEqualTo(채용내용);
        assertThat(jobAdvertisements.get(0).get사용기술()).isEqualTo(사용기술);
    }
}
