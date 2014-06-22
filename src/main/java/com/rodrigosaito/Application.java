package com.rodrigosaito;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PropertyPlaceholderConfigurer propertyOverrideConfigurer() {
        EtcdPropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new EtcdPropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("config.properties"));
        propertyPlaceholderConfigurer.setServerUrl("http://localhost:4001");

        return propertyPlaceholderConfigurer;
    }
}