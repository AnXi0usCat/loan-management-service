package com.mishas.stuff.acs.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mishas.stuff.acs.web"})
public class AcsWebConfig {

    public AcsWebConfig() {
        super();
    }
}
