package com.oliver.experiment;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Oliver
 */
@EnableSwagger2Doc
@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class})
public class ExperimentApplication {

    public static void main (String[] args) {
        SpringApplication.run (ExperimentApplication.class, args);
    }

}
