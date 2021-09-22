## Work Recoding Written by Yoo DaeSun(2021-08-09 ~ )
***
- 2021-08-09
    + thymeleaf 템플릿 사용가능(Dependency 추가)
    + "/"의 정적페이지 이용시 static에 html 생성후, HomeController에서 Request Mapping "/" 제거하면 사용 가능
    + 서버 포트(default) 8080로 접속시 서버 배포 확인 완료.
    + HomeController.java 생성.
    + RestController 사용.
    + 웹서버 작동후 접속시, main 글자 출력완료.
    + view/main.html 생성, templates/main.html 생성(데이터 전송 확인용) 

- 2021-08-10
    + html과 JavaSpringBoot연결에 관하여, GetMapping 으로 연결 가능하다.
    + 연결 방식은 HomeController.Java 참고.
    + @RestController === @Controller + @Responsebody 이다. 따라서 RestController 사용 지향.(우리는 RestFulAPI 개발.)
    + 해당 차이는 `https://devham76.github.io/spring/Spring-controllerRestController/` 참고.
    + Return 되는 ClassPath는 resource/templates/... 으로 할당된다. 따라서 View파일은 Templates밑으로 할당 할 것.

- 2021-08-16
    + ReactJS 서버 추가 완료.
    + 테스팅 미정
    + Readme.md 각각 폴더에 생성 및 Main Readme.md파일에 각각 폴더 위치 추가.
    + Branch 추가 및 변경사항 논의 없음.

- 2021-08-26
    + Dongbok Lee가 만든 RiotAPI(React)항목을 Components 항목으로 정리
    + Promise/Then 으로 짜여있는 Code AsyncFunction으로 정리.
        - Async(){UseEffect}는 작동하지 않음. UseEffect Async사용시, UseEffect(()=>{async()=>{} })로 작성 해야함.
    + User 및 Board, Reply DB Schema 작성 완료.
    + JavaSpringBoot MongoDB Connection 완료.
    + 현재 CRUD 몽고DB 테스팅과정중.


- 2021-08-31
    + ReactJS에서 Form Data로 UserCollection에 Insert기능 구현. 

- 2021-09-03 
    + ID 중복체크 비동기 통신 Logic 구현완료.
    + Back-End Java에서 `UserAPIContoller.java` 생성. 
    + 해당 메서드중 ID중복체크는 User에 관한 Service 항목이므로 `UserService.java`에서 메서드 호출하여 사용 및 실행.
    + 현재 JSONObject로 findBy_id하여 받아오고 있음.
        - 추후 DTO 객체로 받아올 예정. (stram().ModelMapper() 사용예정)
    + Font-End에서 `Axios.get`으로 아이디 등록되어있는지 Server로 전달 및 응답 확인. `(Response? true:false)`

- 2021-09-13
    + PW중복체크 및 정규표현식 이용하여, `true:false State에 반환.`
    + 이메일 또한 정규표현식이용하여 작업.
    +  React에서 `Onchange` 및  `Submmit`과 같이 html에서 사용될 함수명은 handle~으로 작성하는 것으로 규정.
    +  ID중복확인 및 이메일 정규식 확인, 비밀번호 재입력 동일 여부 확인하여 `3중 확인 완료시` Submit 가능하게 만듬. 

- 2021-09-16
    + `Java`
    + PW Bcrypt 암호화 저장`UserService.hashEncodePassword` 및 비교 메서드`UserService.passwordMatch` 생성 완료. 
    + UserApiContoller에서 사용될 계정등록 `UserService.joinId` 메서드 생성 완료.
    + `React`
    + 기본적인 로그인 form 전송시 Submit 메서드 `handleLoginSubmit` 생성. in `login.js`
    + 회원가입 `Join.js` 테스트완료.
    + `요청사항`
    + 박보민에게 로그인과 회원가입 폼을 갖춘 디자인 시안 요청.(예상 기간 1~2일 소요)
  
- 2021-09-18
    + `Java`
    + 로그인시 `JWT`생성 및 전송 기능 구현완료(`AuthService.java`)
    + Unit Test를 통한 JWT생성 단위테스트 통과.
    + `JSONObejct`로 현재 `findBy_id()` 구현되어있으나, `NullException` 문제로 인하여 `Optional<>` 적용중. 
