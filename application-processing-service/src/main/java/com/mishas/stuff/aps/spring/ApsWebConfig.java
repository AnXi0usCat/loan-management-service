package com.mishas.stuff.aps.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.mishas.stuff.aps.web"})
@EnableWebMvc
public class ApsWebConfig {

    public ApsWebConfig() {
        super();
    }
}
