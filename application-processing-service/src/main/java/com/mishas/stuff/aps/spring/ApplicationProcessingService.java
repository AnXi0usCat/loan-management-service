package com.mishas.stuff.aps.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        ApsWebConfig.class,
        ApsServiceConfig.class
})
public class ApplicationProcessingService {

    public static void main(String... args) {
        SpringApplication.run(ApplicationProcessingService.class, args);
    }
}
