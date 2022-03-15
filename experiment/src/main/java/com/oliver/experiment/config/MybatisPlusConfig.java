package com.oliver.experiment.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * mybatis-plus 配置类
 * @author Oliver
 */
@Configuration
@MapperScan ("com.oliver.experiment.mapper")
public class MybatisPlusConfig {
}





@Configuration
@ConditionalOnClass ({SqlSessionFactory.class, SqlSessionFactoryBean.class})
//关键是这个注解：因为容器中有3个数据源，且没有指定主数据源，这个条件不通过，就不会初始化这个配置类了
//这样容器中就没有报错中需要的两个类了
@ConditionalOnSingleCandidate (DataSource.class)
@EnableConfigurationProperties ({MybatisPlusProperties.class})
@AutoConfigureAfter ({DataSourceAutoConfiguration.class})
public class MybatisPlusAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        new SqlSessionFactory    dataSource.
    }
    @Bean
    @ConditionalOnMissingBean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {...}
}

