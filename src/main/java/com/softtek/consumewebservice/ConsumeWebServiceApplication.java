package com.softtek.consumewebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ConsumeWebServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeWebServiceApplication.class, args);
    }

    public SpringApplicationBuilder cofigure(SpringApplicationBuilder builder) {
        return builder.sources(ConsumeWebServiceApplication.class);
    }

}
