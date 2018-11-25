package com.mishas.stuff.lcs.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mishas.stuff.lcs.web"})
public class LcsWebConfig {

    public LcsWebConfig() {
        super();
    }
}
