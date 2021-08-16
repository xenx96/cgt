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
    + 해당 차이는 https://devham76.github.io/spring/Spring-controllerRestController/ 참고.
    + Return 되는 ClassPath는 resource/templates/... 으로 할당된다. 따라서 View파일은 Templates밑으로 할당 할 것.

- 2021-08-16
    + ReactJS 서버 추가 완료.
    + 테스팅 미정
    + Readme.md 각각 폴더에 생성 및 Main Readme.md파일에 각각 폴더 위치 추가.
    + Branch 추가 및 변경사항 논의 없음.
