package com.lm16.uo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties
@EnableAsync
@EnableRetry
public class UoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UoApplication.class, args);
    }

}
