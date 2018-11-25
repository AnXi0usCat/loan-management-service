package com.mishas.stuff.lcs.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        LcsWebConfig.class,
        LcsServiceConfig.class
})
public class LoanCreationService {

    public static void main(String... args) {
        SpringApplication.run(LoanCreationService.class, args);
    }
}