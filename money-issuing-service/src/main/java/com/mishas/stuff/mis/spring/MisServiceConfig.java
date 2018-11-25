package com.mishas.stuff.mis.spring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mishas.stuff.mis.service"})
public class MisServiceConfig {

    public MisServiceConfig() {
        super();
    }
}
