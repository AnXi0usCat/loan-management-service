package com.mishas.stuff.acs.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({
        AcsWebConfig.class,
        AcsServiceConfig.class
})
public class ApplicationCreationService {

    public static void main(String... args) {
        SpringApplication.run(ApplicationCreationService.class, args);
    }
}
