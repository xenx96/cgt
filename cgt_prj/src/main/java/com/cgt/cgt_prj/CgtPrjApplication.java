package com.cgt.cgt_prj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CgtPrjApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgtPrjApplication.class, args);
    }

}
