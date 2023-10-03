package com.example.wantedpreonboardingbackend.service.jobadvertisement;

import com.example.wantedpreonboardingbackend.domain.company.Company;
import com.example.wantedpreonboardingbackend.domain.company.CompanyRepository;
import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisementRepository;
import com.example.wantedpreonboardingbackend.domain.user.UserRepository;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementDeleteDto;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementResponseDto;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementSaveRequestDto;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementUpdateRequestDto;
import com.example.wantedpreonboardingbackend.web.message.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JobAdvertisementService {
    private final JobAdvertisementRepository jobAdvertisementRepository;
    private final CompanyRepository companyRepository;

    // 등록
    @Transactional
    public Result<?> save(Long companyId, JobAdvertisementSaveRequestDto requestDto) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new IllegalArgumentException("해당 회사가 없습니다. companyId = " + companyId));
        JobAdvertisement saved = jobAdvertisementRepository.save(requestDto.toEntity(company));
        return new Result<>(new JobAdvertisementResponseDto(saved));
    }

    // 수정
    @Transactional
    public Result<?> update(Long companyId, Long jobAdvertisementId, JobAdvertisementUpdateRequestDto requestDto) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new IllegalArgumentException("해당 회사가 없습니다. companyId = " + companyId));
        JobAdvertisement jobAdvertisement = jobAdvertisementRepository.findById(jobAdvertisementId).orElseThrow(() -> new IllegalArgumentException("해당 채용 공고가 없습니다. jobAdvertisementId = " + jobAdvertisementId));
        jobAdvertisement.update(requestDto, company);
        return new Result<>(new JobAdvertisementResponseDto(jobAdvertisement));
    }

    // 삭제
    @Transactional
    public Result<?> delete(JobAdvertisementDeleteDto deleteDto) {
        JobAdvertisement entity = jobAdvertisementRepository.findById(deleteDto.getJob_advertisement_id()).orElseThrow(() -> new IllegalArgumentException("해당 채용 공고가 없습니다. jobAdvertisementId = " + deleteDto.getJob_advertisement_id()));
        jobAdvertisementRepository.delete(entity);
        return new Result<>().setMessage("채용공고가 삭제되었습니다.");
    }


    // 전체 조회
    @Transactional
    public Result<?> findAllDesc() {
        List<JobAdvertisementResponseDto> list = jobAdvertisementRepository.findAllDesc().stream()
                .map(JobAdvertisementResponseDto::new)
                .collect(Collectors.toList());
        return new Result<>(list);
    }



}
