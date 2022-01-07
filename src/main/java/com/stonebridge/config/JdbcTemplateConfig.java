package com.stonebridge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {

    @Bean(name = "jdbcTemplateMydb")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.mydb")
    JdbcTemplate jdbcTemplateMydb(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "jdbcTemplateExp")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.mybatisexample")
    JdbcTemplate jdbcTemplateExp(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "jdbcTemplateTestDB")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.testdb")
    JdbcTemplate jdbcTemplateTestDB(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
