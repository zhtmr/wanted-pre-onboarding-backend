<h1>원티드 프리온보딩 백엔드 인턴쉽 과제</h1>

---
- 특징
  - api 응답은 ```Result<?>``` 객체를 사용해 응답 형식 규격화
  - 

1. 채용공고 등록
   1. 요구사항 분석
   2. 구현과정
      - ```JobAdvertisementSaveRequestDto``` 로 요청받아 처리.
      - ```toEntity()``` 메소드를 통해 엔티티 저장
   3. api 테스트
      1. 요청 
      ```http request
      ### 등록
      POST http://localhost:8080/api/v1/job-advertisements/4
      Content-Type: application/json
         
      {         
        "position":"개발자입니다",
        "reward":889,
        "content":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
        "skill":"Java",
        "nation": "한국",
        "region": "서울"
      }
      ```
      2. 응답
      ```http request
       {
         "message": "채용공고가 등록되었습니다.",
         "count": null, //
         "result": null
       }
      ```

---


2. 채용공고 수정
   1. 요구사항 분석
   2. 구현과정
   3. api 테스트
      1. 요청
      2. 응답

---

3. 채용공고 삭제
   1. 요구사항 분석
   2. 구현과정
   3. api 테스트
      1. 요청
      2. 응답

---

4. 채용공고 목록
   1. 요구사항 분석
   2. 구현과정
   3. api 테스트
      1. 요청
      2. 응답

---

5. 채용공고 검색
   1. 요구사항 분석
   2. 구현과정
   3. api 테스트
      1. 요청
      2. 응답

---

6. 채용공고 상세
   1. 요구사항 분석
   2. 구현과정
   3. api 테스트
      1. 요청
      2. 응답

---

5. 채용공고 지원
   1. 요구사항 분석
   2. 구현과정
   3. api 테스트
      1. 요청
      2. 응답
Feat:	새로운 기능 추가 .   
Fix:	버그 수정 또는 typo  
Refactor:	리팩토링  
Design:	CSS 등 사용자 UI 디자인 변경  
Comment:	필요한 주석 추가 및 변경  
Style:	코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우  
Test:	테스트(테스트 코드 추가, 수정, 삭제, 비즈니스 로직에 변경이 없는 경우)  
Chore:	위에 걸리지 않는 기타 변경사항(빌드 스크립트 수정, assets image, 패키지 매니저 등)  
Init:	프로젝트 초기 생성  
Rename:	파일 혹은 폴더명 수정하거나 옮기는 경우  
Remove:	파일을 삭제하는 작업만 수행하는 경우  









