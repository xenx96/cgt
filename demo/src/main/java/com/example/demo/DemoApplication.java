package com.example.demo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//JAVA Version = 11
//Jar, Gradle : Not Maven
//Spring Boot : 2.5.3
//Main Application 
//여기에 뭘 추가 해야 할까요?

//Controller

@SpringBootApplication
@EntityScan(basePackageClasses = {DemoApplication.class})
public class DemoApplication {	

	@PostConstruct
	void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//Test Hello World! 2개 출력해보기 : 작성자(YDS) 2021-08-05
		//성공
		
	}

}
