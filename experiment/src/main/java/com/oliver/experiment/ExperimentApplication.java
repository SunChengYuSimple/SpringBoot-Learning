package com.oliver.experiment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Oliver
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExperimentApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ExperimentApplication.class, args);
    }
    
}