package com.oliver.experiment.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义元数据配置，可在 yaml 中使用
 * @author Oliver
 */
@Data
@Configuration
@ConfigurationProperties ("com.oliver")
public class DidiProperties {

    /**
     * 这是一个测试配置
     * 在 pom.xml 中添加自动生成配置元数据的依赖
     * 然后 mvn install 项目，就可以在 jar 包中找到元数据文件
     * spring-configuration-metadata.json
     * 在配置文件中编写自定义配置项时会有联想提示
     */
    private String name;
}
