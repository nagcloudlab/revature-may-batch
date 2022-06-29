package com.config;

import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnClass(name="com.example.Revature")
//@ConditionalOnMissingClass(value="com.example.Revature")
//@ConditionalOnBean(name = "trainer")
//@ConditionalOnMissingBean(name = "trainer")
//@ConditionalOnProperty(name="app.revature.training")
public class RevatureAutoConfiguration {

    @Bean
    public String revature(){
        return "REVATURE";
    }

}
