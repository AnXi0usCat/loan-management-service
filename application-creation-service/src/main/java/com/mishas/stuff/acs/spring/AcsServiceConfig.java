package com.mishas.stuff.acs.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mishas.stuff.acs.service"})
public class AcsServiceConfig {

    public AcsServiceConfig() {
        super();
    }
}
