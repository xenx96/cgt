# Project CGT(초보 개발자 팀) - Server Dev
- 참여 인원 : 박보민, 유대선, 이동복
- 참여 소속 : 한남대학교 비즈니스통계학 & 컴퓨터공학
- 참여 목적 : OP.GG와 같은 리그 오브 레전드(League of Legends 이하 "롤")의 전적 검색 웹사이트 개발 스터디 
* Folder 
  - Front-End
    + https://github.com/xenx96/cgt/tree/main/cgt_react (ReactJS)
  - Back-End
    + https://github.com/xenx96/cgt/tree/main/cgt_prj (JavaSpringBoot)
    
***
## 개발 서버 현황
* Dev Web 
  - 테스트 서버
    + http://localhost:8080 (JavaSpringBoot-Back-Web)
    + http://localhost:3000 (React.js-Front-Web)
* DataBase
  - 테스트 서버
    + 13.125.207.95:9004 (MongoDB)
* Email Auth
  - Host : Google Mail
  - Account : cgtproject0801
  - Password : application.properties 참조 


   
***
## 1. 개발 이용 스택
```
- Front-End : HTML, CSS, React.JS
- Back-End : Java(Spring Boot Framework) 
- Dev Tool : VSC(유대선), IntelliJ(유대선)
- CodeStyle : Google-Code-Style-Intellij / Prettier-VSC
- Log Lib : logback
- Issued Check From 'github/xenx96/cgt'
```   
***
## 2. 1차 개발 계획
### 2-1 : 롤 전전 검색 API 구현 
```
- 개발 기간 : 2021-08-08 ~ 2021-08-31(API 완료 - 디자인 미적용)
- 세부 계획 및 기능 : 
  1. Riot API(React)추가 - 이동복 2021-08-25
  2. Riot API Components 분리 및 Async Function 변경 - 유대선 2021-08-26
  3. Riot Search 페이지 추가 및 summoner_tier 이미지 추가 - 이동복 2021-08-31
```
### 2-2 : 커뮤니티 생성 및 회원가입, 로그인 구현
```sh
-개발 기간 : 2021-08-29 ~
-세부 계획 및 기능 :
  1. JavaSpringBoot MongoDB 'User'Document Connection - 유대선 2021-08-26
  2. MongoDB Schema 1차 작성 - 유대선 2021-08-26
  3. ReactJS에서 Form Data로 UserCollection에 Insert기능 구현. - 유대선 2021-08-31
  4. 기본 회원가입 Logic '암호화 및 중복확인 포함' 구현. - 유대선 2021-09-16
    4-1. Email인증 및 닉네임 추가 구현 완료 - 유대선 2021-10-01
  5. 로그인 기본 logic 구현. - 유대선 2021-09-16 
  6. 게시판 기본 logic 틀 구현 '생성 수정 삭제' - 이동복 2021-09-23
  7. 유저부분 RestFul API 구현완료. '가입,탈퇴,수정,조회' - 유대선 2021-09-28
  8. 유저 jwt토큰 통한 로그인 세션 확인, 로그아웃, 토큰만료 logic추가 - 이동복 2021-10-03
```
###  배포 및 테스트
```
- 배포 : 도메인(카페 24 예정), 서버(AWS LightSail 예정),
- 개발 테스트 : JUnit(java) 및 Local Test
- 배포전 테스트 : APM Monitoring, Slow Query, Big Traffic, Err Logging, Lock Management,locust, 장애 요인 파악
```
***

### Date At
```bash
'Create' : 2021-08-01
'Start' : 2021-08-03
'Last Update' : 2021-10-03
```
