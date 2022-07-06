package com.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource_dev.properties")
public class DataSourceConfiguration {


//    private final Environment env;
//
//    // spring 5+ , all constructor params will get injected
//    public DataSourceConfiguration(Environment env) {
//        this.env = env;
//    }

    @Value("#{systemProperties['user.country']}")
    String country;

    @Bean
    @Description("Data-source for the underlying RDB we are using")
    public DataSource dataSource(
            @Value("${db_driver}") String driver,
            @Value("${db_url}") String url,
            @Value("${db_username}") String username,
            @Value("${db_password}") String password
    ) {
        System.out.println(country);
        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(env.getProperty("db_driver"));
//        dataSource.setUrl(env.getProperty("db_url"));
//        dataSource.setUsername(env.getProperty("db_username"));
//        dataSource.setPassword(env.getProperty("db_password"));
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(15);
        return dataSource;
    }

//    @Bean
//    public PlatformTransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }


}
