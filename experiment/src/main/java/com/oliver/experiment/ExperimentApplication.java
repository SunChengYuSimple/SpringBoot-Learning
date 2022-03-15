package com.oliver.experiment;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Oliver
 */
@EnableSwagger2Doc
@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class})
// @MapperScan("com.oliver.experiment.mapper")
public class ExperimentApplication {

    public static void main (String[] args) {
        SpringApplication.run (ExperimentApplication.class, args);
    }

}
