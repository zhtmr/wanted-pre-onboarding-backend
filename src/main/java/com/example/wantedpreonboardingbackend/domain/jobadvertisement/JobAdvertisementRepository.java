package com.example.wantedpreonboardingbackend.domain.jobadvertisement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long> {
    @Query("SELECT j FROM JobAdvertisement j ORDER BY j.Id DESC")
    List<JobAdvertisement> findAllDesc();

    // 채용 공고 검색
    @Query("SELECT j FROM JobAdvertisement j WHERE j.company.name LIKE CONCAT(:keyword,'%') OR j.skill LIKE CONCAT(:keyword,'%')")
    List<JobAdvertisement> findJobAdvertisementByContentOrSkillContains(@Param("keyword") String keyword);

    // 상세보기
    @Query("SELECT j.Id FROM JobAdvertisement j WHERE j.company.Id = :companyId AND j.Id != :jobId")
    List<Long> findJobAdvertisementByCompanyDetail(@Param("companyId") Long companyId, @Param("jobId") Long jobId);
}
