package com.mishas.stuff.mis.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.mishas.stuff.mis.web"})
@EnableWebMvc
public class MisWebConfig {

    public MisWebConfig() {
        super();
    }
}
