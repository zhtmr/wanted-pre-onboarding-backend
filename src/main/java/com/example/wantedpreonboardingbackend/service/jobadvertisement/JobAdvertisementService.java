package com.example.wantedpreonboardingbackend.service.jobadvertisement;

import com.example.wantedpreonboardingbackend.domain.company.Company;
import com.example.wantedpreonboardingbackend.domain.company.CompanyRepository;
import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisement;
import com.example.wantedpreonboardingbackend.domain.jobadvertisement.JobAdvertisementRepository;
import com.example.wantedpreonboardingbackend.domain.user.UserRepository;
import com.example.wantedpreonboardingbackend.web.dto.*;
import com.example.wantedpreonboardingbackend.web.message.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class JobAdvertisementService {
    private final JobAdvertisementRepository jobAdvertisementRepository;
    private final CompanyRepository companyRepository;

    // 등록
    @Transactional
    public Result<?> save(Long companyId, JobAdvertisementSaveRequestDto requestDto) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new IllegalArgumentException("해당 회사가 없습니다. companyId = " + companyId));
        jobAdvertisementRepository.save(requestDto.toEntity(company));
        return new Result<>().setMessage("채용공고가 등록되었습니다.");
    }

    // 수정
    @Transactional
    public Result<?> update(Long companyId, Long jobAdvertisementId, JobAdvertisementUpdateRequestDto requestDto) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new IllegalArgumentException("해당 회사가 없습니다. companyId = " + companyId));
        JobAdvertisement jobAdvertisement = jobAdvertisementRepository.findById(jobAdvertisementId).orElseThrow(() -> new IllegalArgumentException("해당 채용 공고가 없습니다. jobAdvertisementId = " + jobAdvertisementId));
        jobAdvertisement.update(requestDto, company);
        return new Result<>().setMessage("채용공고가 수정되었습니다.");
    }

    // 삭제
    @Transactional
    public Result<?> delete(JobAdvertisementDeleteDto deleteDto) {
        JobAdvertisement entity = jobAdvertisementRepository.findById(deleteDto.getJob_advertisement_id()).orElseThrow(() -> new IllegalArgumentException("해당 채용 공고가 없습니다. jobAdvertisementId = " + deleteDto.getJob_advertisement_id()));
        jobAdvertisementRepository.delete(entity);
        return new Result<>().setMessage("채용공고가 삭제되었습니다.");
    }


    // 전체 목록
    @Transactional
    public Result<?> findAllDesc() {
        List<JobAdvertisementResponseDto> list = jobAdvertisementRepository.findAllDesc().stream()
                .map(JobAdvertisementResponseDto::new)
                .collect(Collectors.toList());
        return new Result<>(list).setMessage("채용공고 목록을 불러왔습니다.").setCount(list.size());
    }


    // 검색
    @Transactional
    public Result<?> findJobAdvertisementByContentOrSkillContains(String keyword) {
        List<JobAdvertisementResponseDto> list = jobAdvertisementRepository.findJobAdvertisementByContentOrSkillContains(keyword).stream()
                .map(JobAdvertisementResponseDto::new)
                .collect(Collectors.toList());
        return new Result<>(list).setMessage("검색 결과 입니다.").setCount(list.size());
    }


    // 상세 보기
    public Result<?> findJobAdvertisementByCompanyDetail(Long jobAdvertisementId) {
        JobAdvertisement jobAdvertisement = jobAdvertisementRepository.findById(jobAdvertisementId).orElseThrow(() -> new IllegalArgumentException("채용 공고가 없습니다. jobAdvertisementId = " + jobAdvertisementId));
        Long companyId = jobAdvertisement.getCompany().getId();

        List<Long> list = jobAdvertisementRepository.findJobAdvertisementByCompanyDetail(companyId, jobAdvertisementId);
        JobAdvertisementDetailResponseDto result = new JobAdvertisementDetailResponseDto(jobAdvertisement, list);

        return new Result<>(result).setMessage("채용 상세 입니다.");
    }

}
