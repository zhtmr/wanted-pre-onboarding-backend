package com.example.wantedpreonboardingbackend.web;

import com.example.wantedpreonboardingbackend.service.jobadvertisement.JobAdvertisementService;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementDeleteDto;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementResponseDto;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementSaveRequestDto;
import com.example.wantedpreonboardingbackend.web.dto.JobAdvertisementUpdateRequestDto;
import com.example.wantedpreonboardingbackend.web.message.Result;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/job-advertisements")
public class JobAdvertisementApiController {

    private final JobAdvertisementService jobAdvertisementService;

    // 등록
    @PostMapping("/{companyId}")
    public ResponseEntity<?> save(@PathVariable Long companyId, @RequestBody JobAdvertisementSaveRequestDto requestDto) {
        Result<?> result = jobAdvertisementService.save(companyId, requestDto);
        return new ResponseEntity<Result<?>>(result, HttpStatus.OK);
    }

    // 수정
    @PutMapping("/{companyId}/{jobAdvertisementId}")
    public ResponseEntity<?> update(@PathVariable Long companyId, @PathVariable Long jobAdvertisementId, @RequestBody JobAdvertisementUpdateRequestDto requestDto) {
        Result<?> result = jobAdvertisementService.update(companyId, jobAdvertisementId, requestDto);
        return new ResponseEntity<Result<?>>(result, HttpStatus.OK);
    }

    // 삭제
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody JobAdvertisementDeleteDto deleteDto) {
        Result<?> result = jobAdvertisementService.delete(deleteDto);
        return new ResponseEntity<Result<?>>(result, HttpStatus.OK);
    }

    // 조회
    @GetMapping
    public ResponseEntity<?> selectAll() {
        Result<?> result = jobAdvertisementService.findAllDesc();
        return new ResponseEntity<Result<?>>(result, HttpStatus.OK);
    }

    // 검색
    @GetMapping("/search")
    public ResponseEntity<?> search (@RequestParam String keyword) {
        Result<?> result = jobAdvertisementService.findJobAdvertisementByContentOrSkillContains(keyword);
        return new ResponseEntity<Result<?>>(result, HttpStatus.OK);
    }

    // 상세보기
    @GetMapping("/detail/{jobAdvertisementId}")
    public ResponseEntity<?> detail (@PathVariable Long jobAdvertisementId) {
        Result<?> result = jobAdvertisementService.findJobAdvertisementByCompanyDetail(jobAdvertisementId);
        return new ResponseEntity<Result<?>>(result, HttpStatus.OK);
    }


}
