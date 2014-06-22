package com.rodrigosaito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurableBean {

    private final String config1;
    private final Integer config2;

    @Autowired
    public ConfigurableBean(@Value("${testApp.config1}") final String config1, @Value("${testApp.config2}") final Integer config2) {
        this.config1 = config1;
        this.config2 = config2;
    }

    public String getConfig1() {
        return config1;
    }

    public Integer getConfig2() {
        return config2;
    }
}
