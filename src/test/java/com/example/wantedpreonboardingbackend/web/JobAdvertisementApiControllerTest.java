package com.example.wantedpreonboardingbackend.web;

import com.example.wantedpreonboardingbackend.domain.company.Company;
import com.example.wantedpreonboardingbackend.domain.company.CompanyRepository;
import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisementRepository;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementSaveRequestDto;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementUpdateRequestDto;
import com.example.wantedpreonboardingbackend.web.message.Result;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.as;
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

    @Autowired
    private CompanyRepository companyRepository;

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
        String position = "백엔드 주니어 개발자";
        Integer reward = 1500000;
        String content = "원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..";
        String skill = "Python";
        JobAdvertisementSaveRequestDto requestDto = JobAdvertisementSaveRequestDto.builder()
                .position(position)
                .reward(reward)
                .skill(skill)
                .content(content)
                .build();

        String url = "http://localhost:" + port + "/api/v1/job-advertisements/3";

        // when
        ResponseEntity<Object> responseEntity = testRestTemplate.postForEntity(url, requestDto, Object.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<JobAdvertisement> jobAdvertisements = jobAdvertisementRepository.findAll();
        assertThat(jobAdvertisements.get(0).getPosition()).isEqualTo(position);
        assertThat(jobAdvertisements.get(0).getReward()).isEqualTo(reward);
        assertThat(jobAdvertisements.get(0).getContent()).isEqualTo(content);
        assertThat(jobAdvertisements.get(0).getSkill()).isEqualTo(skill);
    }

    @Test
    public void JobAdvertisement_수정() {
        // given
        JobAdvertisement saved = jobAdvertisementRepository.save(JobAdvertisement.builder()
                .position("이건 채용포지션입니다.")
                .reward(100)
                .content("이건 채용내용")
                .skill("java")
                .build());
        saved.setCompany(companyRepository.findById(3L).orElse(null));
        Long jobId = saved.getId();
        Long companyId = saved.getCompany().getId();
        String expectedPosition = "변경된 채용포지션입니다.";
        String expectedContent = "변경된 채용내용입니다.";

        JobAdvertisementUpdateRequestDto requestDto = JobAdvertisementUpdateRequestDto.builder()
                .position(expectedPosition)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/job-advertisements/" + companyId +"/" + jobId;

        HttpEntity<JobAdvertisementUpdateRequestDto> requestDtoHttpEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Object> responseEntity = testRestTemplate.exchange(url, HttpMethod.PUT, requestDtoHttpEntity, Object.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Optional<JobAdvertisement> find = jobAdvertisementRepository.findById(jobId);

        assertThat(find.get().getPosition()).isEqualTo(expectedPosition);
        assertThat(find.get().getContent()).isEqualTo(expectedContent);

    }
}
