package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//JAVA Version = 11
//Jar, Gradle : Not Maven
//Spring Boot : 2.5.3
//Main Application 
//여기에 뭘 추가 해야 할까요?

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//Test Hello World! 2개 출력해보기 : 작성자(YDS) 2021-08-05
		System.out.println("Hello, World!");
		System.out.println("Hello, World!2");
		//성공
		
	}

}
