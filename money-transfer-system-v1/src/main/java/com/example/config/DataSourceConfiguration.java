package com.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean
    @Description("Data-source for the underlying RDB we are using")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/bankdb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        dataSource.setMaxActive(15);
        return dataSource;
    }


}
