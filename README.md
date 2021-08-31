# Project CGT(초보 개발자 팀) - Server Dev
- 참여 인원 : 박보민, 유대선, 이동복
- 참여 목적 : OP.GG와 같은 리그 오브 레전드(League of Legends 이하 "롤")의 전적 검색 웹사이트 개발   
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
    + 3.37.221.165:9004 (MongoDB)


   
***
## 1. 개발 이용 스택
```
- Front-End : HTML, CSS, React.JS
- Back-End : Java(Spring Boot Framework)
- Dev Tool : VSC(유대선)
- Log Lib : logback
```   
***
## 2. 개발 회차별 계획
### 1회차 : 롤 전전 검색 API 구현
```
- 개발 기간 : 2021-08-08 ~
- 세부 계획 및 기능 : 
  1. Riot API(React)추가 - 이동복 2021-08-25
  2. Riot API Components 분리 및 Async Function 변경 - 유대선 2021-08-26
  3. JavaSpringBoot MongoDB 'User'Document Connection - 유대선 2021-08-26
  4. MongoDB Schema 1차 작성 - 유대선 2021-08-26
  5. Riot Search 페이지 추가 및 summoner_tier 이미지 추가 - 이동복 2021-08-31
```
### 2회차 : 챔피언, 아이템, 특성 정보 및 DB 구축
```
```
### 3회차 : 커뮤니티 생성 및 회원가입, 로그인 구현
```
```
### 4회차 : 배포 및 테스트
```
- 배포 : 도메인(카페 24 예정), 서버(AWS LightSail 예정),
- 테스트 : APM Monitoring, Slow Query, Big Traffic, Err Logging, Lock Management,locust, 장애 요인 파악
```
***


> ## Create At 2021-08-01
 - start : 2021-08-03
