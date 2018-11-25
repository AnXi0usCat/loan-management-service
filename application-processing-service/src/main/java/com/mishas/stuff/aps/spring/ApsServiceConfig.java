package com.mishas.stuff.aps.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.mishas.stuff.aps.service"})
public class ApsServiceConfig {
    public ApsServiceConfig() {
        super();
    }
}
